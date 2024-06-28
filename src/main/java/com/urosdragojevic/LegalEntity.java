package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class LegalEntity extends PanacheEntity {
    public String name;
    @Enumerated(EnumType.STRING)
    public Status status;
    @ManyToOne
    public Employee employee;
    public Address address;
}
