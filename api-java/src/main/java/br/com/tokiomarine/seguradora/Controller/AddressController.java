package br.com.tokiomarine.seguradora.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.dto.CreateAddressDto;
import br.com.tokiomarine.seguradora.model.Address;
import br.com.tokiomarine.seguradora.repository.IAddressRepository;
import br.com.tokiomarine.seguradora.repository.IClientRepository;
import br.com.tokiomarine.seguradora.utils.Utils;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final IAddressRepository repository;
    private final IClientRepository clientRepository;

    public AddressController(IAddressRepository repository, IClientRepository clientRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> pingAddress() {
        return ResponseEntity.ok("Pong Address");
    }

    @PostMapping("/")
    public ResponseEntity<?> createAddress(@RequestBody CreateAddressDto newAddressDto) {
        if (newAddressDto.getIdClient() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Informe o id do cliente");

        var client = clientRepository.findById(newAddressDto.getIdClient()).orElse(null);
        if (client == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");

        var newAddress = new Address();
        newAddressDto.setIdClient(null);

        Utils.copyNonNullProperties(newAddressDto, newAddress);
        newAddress.setClient(client);

        var addressCreated = repository.save(newAddress);
        return ResponseEntity.ok(addressCreated);
    }
}
