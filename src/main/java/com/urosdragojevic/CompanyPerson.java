package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CompanyPerson extends PanacheEntityBase {
    @EmbeddedId
    public CompanyPersonId companyPersonId;

    @ManyToOne
    @MapsId("legalEntityId")
    public Company company;

    @ManyToOne
    @MapsId("personId")
    public Person person;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    public List<PersonRole> roles = new ArrayList<>();
}
