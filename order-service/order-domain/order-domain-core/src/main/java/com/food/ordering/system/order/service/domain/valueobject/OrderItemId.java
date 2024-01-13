package com.food.ordering.system.order.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseId;

/**
 * the uniqueness of the value object is the important thing, so we can use Long as a generic parameter instead of UUID
 */
public class OrderItemId extends BaseId <Long>{

    /**
     * Protected constructor to be used by subclasses for creating instances of BaseId.
     *
     * @param value The value to be set as the identity.
     */
    protected OrderItemId(Long value) {
        super(value);
    }
}
