package br.com.tokiomarine.seguradora.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.model.Client;
import br.com.tokiomarine.seguradora.repository.IAddressRepository;
import br.com.tokiomarine.seguradora.repository.IClientRepository;
import br.com.tokiomarine.seguradora.utils.Utils;

@RestController
@RequestMapping("/api/client")
public class ClientController {


    private final IClientRepository repository;

    public ClientController(IClientRepository repository, IAddressRepository IAddressRepository) {
        this.repository = repository;
    }

    @GetMapping("/ping")
    public ResponseEntity<String> pingClient() {
        return ResponseEntity.ok("Pong Client");
    }


    @PostMapping("/")
    public ResponseEntity<?> createClient(@RequestBody Client newClient) {
        var client = repository.findByEmail(newClient.getEmail());

        if(client != null) 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente já existe");

        var clientCreated = repository.save(newClient);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientCreated);
    }

    @GetMapping("/")
    public ResponseEntity<List<Client>> listClients () {
        return ResponseEntity.ok(repository.findAll());
    }


    @PutMapping("/{idClient}")
    public ResponseEntity<?> updateClient(@RequestBody Client newInfosClient, @PathVariable Long idClient) {
        var client = repository.findById(idClient).orElse(null);

        if(client == null) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");

        var clientEmail = repository.findByEmail(newInfosClient.getEmail());

        if(clientEmail!=null && !clientEmail.getId().equals(client.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este email não pode ser utilizado");

        newInfosClient.setId(client.getId());

        Utils.copyNonNullProperties(newInfosClient, client);

        var clientUpdated = repository.save(client);

        return ResponseEntity.ok(clientUpdated);
        
    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<?> deleteClient(@PathVariable Long idClient) {
        var client = repository.findById(idClient).orElse(null);

        if(client == null) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");


        repository.delete(client);
            
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }
    
}
