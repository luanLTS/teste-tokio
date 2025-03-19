package br.com.tokiomarine.seguradora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.model.Address;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    
}
