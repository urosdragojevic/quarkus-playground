package com.urosdragojevic.panache_rest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class CompanyStore {
    @EmbeddedId
    public CompanyStoreId id = new CompanyStoreId();
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("companyId")
    @JsonBackReference
    public Company company;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("storeId")
    public Store store;
    public String extraCol;
}
