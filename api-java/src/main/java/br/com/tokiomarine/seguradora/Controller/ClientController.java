package br.com.tokiomarine.seguradora.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.model.Client;
import br.com.tokiomarine.seguradora.repository.IClientRepository;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final IClientRepository repository;

    public ClientController(IClientRepository repository) {
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
    
}
