package com.urosdragojevic;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@Entity
public class Product extends PanacheEntity {
    public String productName;
    public int price;
    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    @Schema(hidden = true)
    public List<Company> companies;
}
