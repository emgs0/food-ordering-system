package com.food.ordering.system.order.service.domain.ports.output.repository;

import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.valueobject.TrackingId;

import java.util.Optional;
/**
 * The {@code OrderRepository} interface defines methods for managing order-related
 * operations in the underlying data storage.
 */
public interface OrderRepository {
    /**
     * Saves the provided order entity into the data storage.
     *
     * @param order The order entity to be saved.
     * @return The saved order entity.
     */
    Order save(Order order);
    /**
     * Finds and returns an order entity with the specified tracking identifier.
     *
     * @param trackingId The tracking identifier of the order to be retrieved.
     * @return An {@code Optional} containing the order if found, or an empty {@code Optional} otherwise.
     */
    Optional<Order> findByTrackingId(TrackingId trackingId);
}
