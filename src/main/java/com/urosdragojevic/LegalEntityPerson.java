package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;

@Entity
public class LegalEntityPerson extends PanacheEntityBase {
    @EmbeddedId
    public LegalEntityPersonId legalEntityPersonId;

    @ManyToOne
    @MapsId("legalEntityId")
    public LegalEntity legalEntity;

    @ManyToOne
    @MapsId("personId")
    public Person person;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    public List<PersonRole> roles = new ArrayList<>();
}
