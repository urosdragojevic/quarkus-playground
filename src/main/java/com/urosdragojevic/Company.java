package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
public class Company extends PanacheEntity {
    public String name;
    @Enumerated(EnumType.STRING)
    public Status status;
    public Address address;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    public List<TaxInformation> taxInformation;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    public Website website;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    @NotNull
    public List<Person> persons;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    public List<Vehicle> vehicles;

    @PrePersist
    public void prePersist() {
        // Handle existing website updates
        // Otherwise, throws EntityExistsException when id is provided
        if (website.id != null) {
            Website existing = Website.findById(website.id);
            if (existing != null) {
                Website w = getEntityManager().merge(existing);
                w.domain = website.domain;
                this.website = w;
            }
        }
        // Handle bidirectional relationship
        for (Person p : persons) {
            p.company = this;
        }
    }
}
