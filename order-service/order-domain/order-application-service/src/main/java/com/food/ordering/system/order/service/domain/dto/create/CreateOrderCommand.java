package com.food.ordering.system.order.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * The {@code CreateOrderCommand} class represents a command to create a new order.
 * It includes essential information such as customer ID, restaurant ID, price, items,
 * and delivery address.
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateOrderCommand {
    /**
     * The unique identifier of the customer placing the order.
     */
    @NotNull
    private final UUID customerId;
    /**
     * The unique identifier of the restaurant where the order is placed.
     */
    @NotNull
    private final UUID restaurantId;
    /**
     * The total price of the order.
     */
    @NotNull
    private final BigDecimal price;
    /**
     * The list of items included in the order.
     */
    @NotNull
    private final List<OrderItem> items;
    /**
     * The delivery address for the order.
     */
    @NotNull
    private final OrderAddress address;
}
