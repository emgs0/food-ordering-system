package com.food.ordering.system.domain.event.publisher;

import com.food.ordering.system.domain.event.DomainEvent;
/**
 * The {@code DomainEventPublisher} interface defines the contract for classes
 * responsible for publishing domain events within the system.
 *
 * @param <T> The type of {@code DomainEvent} to be published.
 */
public interface DomainEventPublisher<T extends DomainEvent> {
    /**
     * Publishes the specified domain event to notify interested components in the system.
     *
     * @param domainEvent The domain event to be published.
     */
    void publish(T domainEvent);
}
