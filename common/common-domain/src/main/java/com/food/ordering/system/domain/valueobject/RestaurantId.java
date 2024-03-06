package com.food.ordering.system.domain.valueobject;

import java.util.UUID;

public class RestaurantId extends BaseId<UUID> {
    /**
     * Protected constructor to be used by subclasses for creating instances of BaseId.
     *
     * @param value The value to be set as the identity.
     */
    public RestaurantId(UUID value) {
        super(value);
    }
}
