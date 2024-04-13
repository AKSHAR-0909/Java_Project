package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;

    private String discountType;

    private float threshold;

    @Transient // Exclude from persistence
    private DiscountStrategy discountStrategy;

    // Getters and Setters

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public float applyDiscount(float price) {
        if (discountStrategy != null) {
            return discountStrategy.applyDiscount(price);
        }
        return price;
    }
}
