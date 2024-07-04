package com.urosdragojevic;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
public class Person extends PanacheEntity {
    public String firstName;
    public String lastName;
    @Enumerated(EnumType.STRING)
    public PersonRole role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    public Company company;
}
