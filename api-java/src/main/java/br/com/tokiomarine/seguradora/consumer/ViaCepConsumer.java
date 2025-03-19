package br.com.tokiomarine.seguradora.consumer;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import br.com.tokiomarine.seguradora.dto.ViaCepDto;

public class ViaCepConsumer {
    private static final RestTemplate restTemplate = new RestTemplate();

    public static ViaCepDto fetchByPostalCode(String postalCode) {
        var response = restTemplate.getForEntity("https://viacep.com.br/ws/" + postalCode + "/json/", ViaCepDto.class);
        if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST))
            return null;
        var body = response.getBody();
        return body;
    }
}
