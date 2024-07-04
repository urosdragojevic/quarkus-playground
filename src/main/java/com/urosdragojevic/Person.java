package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Person extends PanacheEntity {
    public String firstName;
    public String lastName;
    @Enumerated(EnumType.STRING)
    public PersonRole role;
}
