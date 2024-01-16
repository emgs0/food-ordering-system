package com.food.ordering.system.order.service.domain.entity;
import com.food.ordering.system.domain.entity.BaseEntity;
import com.food.ordering.system.domain.valueobject.Money;
import com.food.ordering.system.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    /**
     * This entity does not need to nullify the hashCode, because equals methods and hashcode are overridden on BaseEntity
     * in the common-domain package.
     * Value objects are immutable and only hold data, so identifier is not important for them.
     * That means that two value objects with the same data, but different id’s considered to be the same value object.
     */
    private String name;
    private Money price;

    public Product(ProductId productId, String name, Money price) {
        super.setId(productId);
        this.name = name;
        this.price = price;
    }
    public void updateWithConfirmedNameAndPrice(String name, Money price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }


}
