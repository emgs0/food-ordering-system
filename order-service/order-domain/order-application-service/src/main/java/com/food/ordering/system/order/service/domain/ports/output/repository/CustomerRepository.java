package com.food.ordering.system.order.service.domain.ports.output.repository;

import com.food.ordering.system.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;
/**
 * The {@code CustomerRepository} interface defines methods for retrieving customer-related
 * information from the underlying data storage.
 */
public interface CustomerRepository {
    /**
     * Finds and returns a customer with the specified unique identifier.
     *
     * @param customerId The unique identifier of the customer to be retrieved.
     * @return An {@code Optional} containing the customer if found, or an empty {@code Optional} otherwise.
     */
    Optional<Customer> findCustomer(UUID customerId);
}
