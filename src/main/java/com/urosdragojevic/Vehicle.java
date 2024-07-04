package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Vehicle extends PanacheEntity {
    public String model;
}
