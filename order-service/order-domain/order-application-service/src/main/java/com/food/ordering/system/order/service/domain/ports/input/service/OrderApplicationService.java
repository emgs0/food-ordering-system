package com.food.ordering.system.order.service.domain.ports.input.service;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;
/**
 * The {@code OrderApplicationService} interface defines methods for handling order-related operations
 * in the application layer. It includes functionalities to create an order and track the status of an order.
 */
public interface OrderApplicationService {
    /**
     * Creates a new order based on the provided {@code CreateOrderCommand}.
     *
     * @param createOrderCommand The command containing information to create the order.
     * @return A response indicating the result of the order creation.
     */
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    /**
     * Tracks the status of an order based on the provided {@code TrackOrderQuery}.
     *
     * @param trackOrderQuery The query containing information to track the order.
     * @return A response providing information about the current status of the tracked order.
     */
    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
