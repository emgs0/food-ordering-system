package com.food.ordering.system.order.service.domain.ports.input.message.listener.restaurantapproval;
import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse;
/**
 * The {@code RestaurantApprovalResponseMessageListener} interface defines methods for handling
 * restaurant approval response messages. Implementing classes should provide logic for processing
 * approved and rejected restaurant approval responses.
 */
public interface RestaurantApprovalResponseMessageListener {
    /**
     * Handles the approval of a restaurant order, triggered by a restaurant approval response.
     *
     * @param restaurantApprovalResponse The restaurant approval response indicating an approved order.
     */
    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);
    /**
     * Handles the rejection of a restaurant order, triggered by a restaurant approval response.
     *
     * @param restaurantApprovalResponse The restaurant approval response indicating a rejected order.
     */
    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
