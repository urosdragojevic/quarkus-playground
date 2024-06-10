package com.urosdragojevic.id;

import jakarta.persistence.GeneratedValue;

import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

public abstract class EntityId<T> {
    @GeneratedValue
    private UUID id;

    public UUID getId() {
        return id;
    }

    protected void setId(UUID id) {
        this.id = id;
    }

    public static <T extends EntityId<?>> T fromString(Supplier<T> supplier, String s) {
        T obj = supplier.get();
        UUID uuid = UUID.fromString(s);
        obj.setId(uuid);
        return obj;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EntityId<?> entityId)) return false;

        return id != null && Objects.equals(id, entityId.id);
    }

    // TODO: check if necessary to switch to getClass.hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
