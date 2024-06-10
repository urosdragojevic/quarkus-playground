package com.urosdragojevic;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class DomainTest {
    @Inject
    EntityManager entityManager;

    @Test
    @TestTransaction
    void saveDomain() {
        Domain domain = new Domain();
        entityManager.persist(domain);
        Domain result = entityManager.find(Domain.class, domain.getId());
        System.out.println(result.getId());
        assertNotNull(result);
    }

    @Test
    @TestTransaction
    void saveDomainSet() {

        Domain one = new Domain();
        Domain two = new Domain();

        Domain.Id idOne = new Domain.Id();
        Domain.Id idTwo = new Domain.Id();

        assertNotEquals(idOne, idTwo);

        assertNotEquals(one, two);
        assertNotEquals(one.getId(), two.getId());

        Set<Domain> domains = Set.of(one, two);

        entityManager.persist(one);
        entityManager.persist(two);

        String jpqlQuery = "SELECT d FROM Domain d";
        Query query = entityManager.createQuery(jpqlQuery, Domain.class);
        List<Domain> result = query.getResultList();

        assertEquals(2, result.size());
        assertTrue(result.contains(one));
        assertTrue(result.contains(two));

        Domain found = entityManager.find(Domain.class, one.getId());
        System.out.println(found);
        System.out.println(found.equals(one));

    }

    @Test
    @TestTransaction
    protected void assertEqualityConsistency() {
        Domain entity = new Domain();
        entity.setName("Hello");
        Set<Domain> tuples = new HashSet<>();

        assertFalse(tuples.contains(entity));
        tuples.add(entity);
        assertTrue(tuples.contains(entity));

        entityManager.persist(entity);
        entityManager.flush();
        assertTrue(tuples.contains(entity));

        System.out.println(entity.getId());

        assertTrue(tuples.contains(entity));

        Domain entityProxy = entityManager.getReference(
                Domain.class,
                entity.getId()
        );
        assertEquals(entityProxy, entity);

        Domain proxy = entityManager.getReference(
                Domain.class,
                entity.getId()
        );
        assertEquals(entity, proxy);

        Domain _entity = entityManager.merge(entity);
        assertTrue(tuples.contains(_entity));

        entityManager.unwrap(Session.class).update(entity);
        assertTrue(tuples.contains(entity));

        Domain d = entityManager.find(Domain.class, entity.getId());
        assertTrue(tuples.contains(d));

        Domain e = entityManager.getReference(Domain.class, entity.getId());
        assertTrue(tuples.contains(e));

        Domain f = entityManager.getReference(
                Domain.class,
                entity.getId()
        );
        entityManager.remove(f);

        assertTrue(tuples.contains(f));
    }

}
