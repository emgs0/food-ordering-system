package com.food.ordering.system.order.service.domain.dto.create;

import com.food.ordering.system.domain.valueobject.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.UUID;
/**
 * The {@code CreateOrderResponse} class represents the response of a successful order creation.
 * It includes essential information such as the order tracking ID, order status, and a descriptive message.
 */
@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    /**
     * The unique identifier used to track the newly created order.
     */
    @NotNull
    private final UUID orderTrackingId;
    /**
     * The status of the created order.
     */
    @NotNull
    private final OrderStatus orderStatus;
    /**
     * A descriptive message providing additional information about the order creation.
     */
    @NotNull
    private final String message;

}
