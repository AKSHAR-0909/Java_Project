package com.example.model;

public class FixedDiscount implements Discount {
    private float discountAmount;

    public FixedDiscount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public float applyDiscount(float amount) {
        return amount - discountAmount;
    }
}
