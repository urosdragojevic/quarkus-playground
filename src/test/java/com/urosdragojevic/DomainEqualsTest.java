package com.urosdragojevic;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

public class DomainEqualsTest {
    @Test
    void testEquality() {
        EqualsVerifier.forClass(Domain.class)
                .suppress(
                        Warning.IDENTICAL_COPY_FOR_VERSIONED_ENTITY,
                        Warning.SURROGATE_KEY,
                        Warning.STRICT_HASHCODE
                )
                .verify();
    }
}
