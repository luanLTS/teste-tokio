package br.com.tokiomarine.seguradora.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.tokiomarine.seguradora.repository.IClientRepository;

@CrossOrigin
@RequestMapping("/api/client")
public class ClientController {

    private final IClientRepository repository;

    public ClientController(IClientRepository repository) {
        this.repository = repository;
    }
    
}
