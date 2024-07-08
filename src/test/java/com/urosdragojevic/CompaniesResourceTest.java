package com.urosdragojevic;

import com.urosdragojevic.panache_rest.CompaniesResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CompaniesResourceTest {
    @Inject
    CompaniesResource companiesResource;

    // TODO: Add RestAssured e2e tests

    @Test
    void setupRuns() {
        assertNotNull(companiesResource);
    }
}
