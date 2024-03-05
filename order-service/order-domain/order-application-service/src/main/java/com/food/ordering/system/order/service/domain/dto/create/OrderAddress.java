package com.food.ordering.system.order.service.domain.dto.create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
/**
 * The {@code OrderAddress} class represents the address information associated with an order.
 * It includes details such as street, zip code, and city.
 */
@Getter
@Builder
@AllArgsConstructor
public class OrderAddress {
    /**
     * The street address for delivery.
     */
    @NotNull
    @Size(max = 50)
    private final String street;

    /**
     * The zip code of the delivery address.
     */
    @NotNull
    @Size(max = 10)
    private final String zipCode;

    /**
     * The city of the delivery address.
     */
    @NotNull
    @Size(max = 50)
    private final String city;
}
