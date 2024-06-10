package com.urosdragojevic;

import com.urosdragojevic.id.EntityId;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Domain {
    @EmbeddedId
    private Id id = new Id();

    private String name;

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String someField) {
        this.name = someField;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Domain domain)) return false;

        return id != null && id.equals(domain.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Embeddable
    public static class Id extends EntityId<Id> {
        public static Id fromString(String s) {
            return EntityId.fromString(Id::new, s);
        }
    }
}
