package com.urosdragojevic;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DomainService {
    @Inject
    EntityManager entityManager;

    @Transactional
    public Domain createDomain(String name) {
        Domain domain = new Domain();
        domain.setName(name);
        entityManager.persist(domain);
        return domain;
    }

    public List<Domain> getDomains() {
        String jpqlQuery = "SELECT d FROM Domain d";
        Query query = entityManager.createQuery(jpqlQuery, Domain.class);
        return (List<Domain>) query.getResultList();
    }

    @Transactional
    public Domain editDomain(Domain.Id domainId, String name) {
        Domain domain = entityManager.find(Domain.class, domainId);
        domain.setName(name);
        entityManager.persist(domain);
        return domain;
    }
}
