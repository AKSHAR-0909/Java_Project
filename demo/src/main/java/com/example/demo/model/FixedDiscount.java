package com.example.demo.model;

public class FixedDiscount implements Discount {
    private float amount;

    public FixedDiscount(float amount) {
        this.amount = amount;
    }

    @Override
    public float applyDiscount(float originalAmount) {
        return originalAmount - amount;
    }

    @Override
    public float getAmount() {
        return amount;
    }
}
