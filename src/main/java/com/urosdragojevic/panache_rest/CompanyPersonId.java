package com.urosdragojevic.panache_rest;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompanyPersonId {
    @Column(name = "legal_entity_id")
    public Long legalEntityId;
    @Column(name = "person_id")
    public Long personId;
}
