package br.com.tokiomarine.seguradora.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.repository.IAddressRepository;

@RestController
@RequestMapping("/api/address")
public class AddressController {


    private final IAddressRepository repository;

    public AddressController(IAddressRepository repository) {
        this.repository = repository;
    }

}
