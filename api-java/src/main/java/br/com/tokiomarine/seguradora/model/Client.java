package br.com.tokiomarine.seguradora.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name", nullable=false, columnDefinition="VARCHAR(250)")
    private String firstName;

    @Column(name="last_name", nullable=true, columnDefinition="VARCHAR(250)")
    private String lastName;

    @Column(name="email", nullable=false, columnDefinition="VARCHAR(250)")
    private String email;
}