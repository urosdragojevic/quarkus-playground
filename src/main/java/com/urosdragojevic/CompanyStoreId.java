package com.urosdragojevic;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
public class CompanyStoreId implements Serializable {
    @Column(name = "company_id")
    public Long companyId;
    @Column(name = "store_id")
    public Long storeId;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyStoreId that)) return false;

        return Objects.equals(companyId, that.companyId) && Objects.equals(storeId, that.storeId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(companyId);
        result = 31 * result + Objects.hashCode(storeId);
        return result;
    }
}
