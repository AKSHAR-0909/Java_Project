
package com.example.demo.model;

public class FixedDiscountStrategy implements DiscountStrategy {
    private float discountAmount;

    public FixedDiscountStrategy(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public float applyDiscount(float price) {
        return discountAmount;
    }
}
