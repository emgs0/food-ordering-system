package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.domain.valueobject.ProductId;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.entity.Product;
import com.food.ordering.system.order.service.domain.entity.Restaurant;
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import lombok.extern.slf4j.Slf4j;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService{

    private static final String zoneId = "America/Mexico_City";
    /**
     * @param order
     * @param restaurant
     * @return
     */
    @Override
    public OrderCreatedEvent validateAndInitiateOrder(Order order, Restaurant restaurant) {
        validateRestaurant(restaurant);
        setOrderProductInformation(order, restaurant);
        order.validateOrder();
        order.initializeOrder();

        log.info("Order with id:{} is initiated",order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(zoneId)));
    }



    /**
     * @param order
     * @return
     */
    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with id: {} is paid", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(zoneId)));
    }

    /**
     * @param order
     */
    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with id: {} is approved",order.getId().getValue());


    }

    /**
     * @param order
     * @param failureMessages
     * @return
     */
    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order payment is cancelling for order id: {}",order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(zoneId)));
    }

    /**
     * @param order
     * @param failureMessages
     */
    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with id: {} is cancelled",order.getId().getValue());
    }

    private void validateRestaurant(Restaurant restaurant) {
        if(!restaurant.isActive()){
            throw new OrderDomainException("Restaurant with id " + restaurant.getId().getValue() +
                    " is currently not active!");
        }
    }
    /**
     * Updates product information in the given order using data from the provided restaurant.
     * This method compares products in the order with those in the restaurant and updates
     * the product information in the order with the corresponding data from the restaurant.
     * <p>
     * The method uses an optimized approach by employing a HashMap to reduce the time complexity
     * from quadratic (O(n^2)) to linear (O(n)).
     * </p>
     *
     * @param order      The order object whose product information needs to be updated.
     * @param restaurant The restaurant object containing the source of updated product information.
     */
    private void setOrderProductInformation(Order order, Restaurant restaurant) {
        // Obsolete code with nested foreach (quadratic time complexity - O(n^2))
        /*
            order.getItems().forEach(orderItem ->
            // For each OrderItem, iterate through the products (Product) in the restaurant's product list (Restaurant)
            restaurant.getProducts().forEach(restaurantProduct -> {
                // Get the current product (Product) from the OrderItem
                Product currentProduct = orderItem.getProduct();
                // Check if the current product in the order is equal to the product in the restaurant
                if (currentProduct.equals(restaurantProduct)) {
                    // If they are equal, update the product information in the order with the restaurant information
                    currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(),
                            restaurantProduct.getPrice());
                }
            }));
        */

        // Optimized code using a HashMap (linear time complexity - O(n))
        // Create a HashMap to store restaurant products by their identifier
        Map<ProductId, Product> restaurantProductMap = new HashMap<>();
        restaurant.getProducts().forEach(product -> restaurantProductMap.put(product.getId(), product));

        // Iterate through the items (OrderItem) in the order's item list (Order)
        order.getItems().forEach(orderItem -> {
            // Get the current product (Product) from the OrderItem
            Product currentProduct = orderItem.getProduct();

            // Look up the product in the HashMap using the product's identifier
            Product restaurantProduct = restaurantProductMap.get(currentProduct.getId());

            // Check if the restaurant product exists
            if (restaurantProduct != null) {
                // If it exists, update the product information in the order with the restaurant information
                currentProduct.updateWithConfirmedNameAndPrice(restaurantProduct.getName(), restaurantProduct.getPrice());
            }
        });
    }
}
