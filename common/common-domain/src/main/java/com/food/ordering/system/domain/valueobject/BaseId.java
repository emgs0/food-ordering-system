package com.food.ordering.system.domain.valueobject;

import java.util.Objects;

/**
 * This abstract class represents a base class for identity values in the domain model.
 *
 * @param <T> The generic type of the identity value.
 */
public abstract class BaseId<T> {

    /**
     * The actual value of the identity.
     */
    private final T value;

    /**
     * Protected constructor to be used by subclasses for creating instances of BaseId.
     *
     * @param value The value to be set as the identity.
     */
    protected BaseId(T value) {
        this.value = value;
    }

    /**
     * Retrieves the value of the identity.
     *
     * @return The value of the identity.
     */
    public T getValue() {
        return value;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return Objects.equals(value, baseId.value);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
