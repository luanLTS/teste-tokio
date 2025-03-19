package br.com.tokiomarine.seguradora.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.model.Address;
import br.com.tokiomarine.seguradora.repository.IClientRepository;

@Service
public class AddressService {

    @PersistenceContext
    private EntityManager em;

    private final IClientRepository clientRepository;

    public AddressService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Address> listWithFilters(Map<String, String> filterMap) {
        var cb = em.getCriteriaBuilder();
        var query = cb.createQuery(Address.class);
        var root = query.from(Address.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filterMap.containsKey("client_id")) {
            var client = clientRepository.findById(Long.parseLong(filterMap.get("client_id")))
                    .orElse(null);
            predicates.add(cb.equal(root.get("client"), client));
        }
        // filtros futuros

        var list = em.createQuery(query.where(predicates.toArray(new Predicate[0]))).getResultList();
        return list;
    }

}
