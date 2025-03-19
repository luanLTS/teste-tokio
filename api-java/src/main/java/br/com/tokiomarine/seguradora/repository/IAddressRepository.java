package br.com.tokiomarine.seguradora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.model.Address;
import br.com.tokiomarine.seguradora.model.Client;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByClient(Client client);
}
