package com.urosdragojevic;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;

public interface LegalEntityResource extends PanacheEntityResource<Company, Long> {
}
