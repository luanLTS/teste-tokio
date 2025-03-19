package br.com.tokiomarine.seguradora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address", nullable = false, columnDefinition = "VARCHAR(250)")
    private String address;

    @Column(name = "number", nullable = false, columnDefinition = "VARCHAR(20)")
    private String number;

    @Column(name = "complement", nullable = true, columnDefinition = "VARCHAR(250)")
    private String complement;

    @Column(name = "postal_code", nullable = true, columnDefinition = "VARCHAR(10)")
    private String postalCode;

    @Column(name = "city", nullable = true, columnDefinition = "VARCHAR(250)")
    private String city;

    @Column(name = "state", nullable = true, columnDefinition = "VARCHAR(250)")
    private String state;

    @Column(name = "country", nullable = true, columnDefinition = "VARCHAR(250)")
    private String country;

    @ManyToOne()
    @JoinColumn(name = "id_client")
    private Client client;
}
