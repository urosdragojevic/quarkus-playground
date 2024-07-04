package com.urosdragojevic;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Website extends PanacheEntity {
    public String domain;
    @OneToOne(mappedBy = "website")
    @JsonBackReference
    public Company company;
}
