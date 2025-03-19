package br.com.tokiomarine.seguradora.dto;

import lombok.Data;

@Data
public class CreateAddressDto {
    private String address;

    private String number;

    private String complement;

    private String postalCode;

    private String city;

    private String state;

    private String country;

    private Long idClient;
}
