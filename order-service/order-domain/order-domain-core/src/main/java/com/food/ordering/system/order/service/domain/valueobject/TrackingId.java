package com.food.ordering.system.order.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    /**
     * Protected constructor to be used by subclasses for creating instances of BaseId.
     *
     * @param value The value to be set as the identity.
     */
    public TrackingId(UUID value) {
        super(value);
    }
}
