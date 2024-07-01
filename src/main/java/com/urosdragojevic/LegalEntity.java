package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@Entity
public class LegalEntity extends PanacheEntity {
    public String name;
    @Enumerated(EnumType.STRING)
    public Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    public Employee employee;
    public Address address;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    public List<TaxInformation> taxInformation;
    @OneToMany(mappedBy = "legalEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<LegalEntityPerson> persons;
}
