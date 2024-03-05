package com.food.ordering.system.order.service.domain.ports.output.repository;

import com.food.ordering.system.order.service.domain.entity.Restaurant;

import java.util.Optional;
/**
 * The {@code RestaurantRepository} interface defines methods for retrieving restaurant-related
 * information from the underlying data storage.
 */
public interface RestaurantRepository {
    /**
     * Finds and returns information about a restaurant based on the provided restaurant entity.
     *
     * @param restaurant The restaurant entity for which information is to be retrieved.
     * @return An {@code Optional} containing the restaurant information if found,
     *         or an empty {@code Optional} otherwise.
     */
    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);

}
