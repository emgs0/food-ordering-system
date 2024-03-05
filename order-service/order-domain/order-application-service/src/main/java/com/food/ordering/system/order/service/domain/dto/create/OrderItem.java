package com.food.ordering.system.order.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;
/**
 * The {@code OrderItem} class represents an item included in an order.
 * It contains information about the product, quantity, price per unit, and subtotal.
 */
@Getter
@Builder
@AllArgsConstructor
public class OrderItem {
    /**
     * The unique identifier of the product in the order item.
     */
    @NotNull
    private final UUID productId;
    /**
     * The quantity of the product in the order item.
     */
    @NotNull
    private final Integer quantity;
    /**
     * The price per unit of the product.
     */
    @NotNull
    private final BigDecimal price;
    /**
     * The subtotal for the order item, calculated as quantity multiplied by price.
     */
    @NotNull
    private final BigDecimal subTotal;
}
