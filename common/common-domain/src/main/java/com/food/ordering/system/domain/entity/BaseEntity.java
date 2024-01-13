package com.food.ordering.system.domain.entity;

import java.util.Objects;

/**
 * This abstract class has the generic ID variable, this class will be extended for each class (Value Objects)
 * and replace the ID generic with this Identifier type Entity
 * @param <ID>
 */
public abstract class BaseEntity<ID> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    /**
     * These two methods are contracts to compare Value Objects in Java
     * @param o its a generic Value object
     * @return true or false depending on the context
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity<?> that = (BaseEntity<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
