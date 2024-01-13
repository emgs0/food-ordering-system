package com.food.ordering.system.domain.valueobject;

import java.util.UUID;

/**
 * This class represents the identity value for an Order in the domain model.
 * It extends the BaseId class, which is a generic base class for identity values.
 *
 * @see BaseId
 */
public class OrderId extends BaseId<UUID> {

    /**
     * Constructs an OrderId with the specified UUID value.
     *
     * @param value The UUID value to be set as the identity of the order.
     */
    protected OrderId(UUID value) {
        super(value);
    }
}
