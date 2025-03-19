package br.com.tokiomarine.seguradora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
}