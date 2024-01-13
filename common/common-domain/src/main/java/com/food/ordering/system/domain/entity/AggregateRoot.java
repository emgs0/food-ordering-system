package com.food.ordering.system.domain.entity;

/**
 * With this abstract class, we will mark an Aggregate Class because it will extend this class, to difference which
 * class is an entity or aggregate, this class extends Base entity to reuse setter & getter of ID
 * @param <ID>
 */
public abstract class AggregateRoot<ID> extends BaseEntity<ID>{

}
