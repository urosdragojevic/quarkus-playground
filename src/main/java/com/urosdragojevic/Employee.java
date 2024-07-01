package com.urosdragojevic;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends PanacheEntity {
    @Email
    public String email;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    @JsonBackReference
    public List<Company> assignedTo = new ArrayList<>();
}
