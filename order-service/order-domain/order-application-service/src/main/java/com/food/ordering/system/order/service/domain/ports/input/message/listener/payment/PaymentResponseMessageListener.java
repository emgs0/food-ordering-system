package com.food.ordering.system.order.service.domain.ports.input.message.listener.payment;
import com.food.ordering.system.order.service.domain.dto.message.PaymentResponse;
/**
 * The {@code PaymentResponseMessageListener} interface defines methods for handling
 * payment response messages. Implementing classes should provide logic for processing
 * completed and canceled payment responses.
 */
public interface PaymentResponseMessageListener {
    /**
     * Handles the completion of a payment, triggered by a payment response.
     *
     * @param paymentResponse The payment response indicating a completed payment.
     */
    void paymentCompleted(PaymentResponse paymentResponse);
    /**
     * Handles the cancellation of a payment, triggered by a payment response.
     *
     * @param paymentResponse The payment response indicating a canceled payment.
     */
    void paymentCanceled(PaymentResponse paymentResponse);
}
