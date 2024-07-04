package com.urosdragojevic;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Website website;
}
