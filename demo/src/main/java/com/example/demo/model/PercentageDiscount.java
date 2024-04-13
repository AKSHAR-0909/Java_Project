package com.example.demo.model;

public class PercentageDiscount implements Discount {
    private float percentage;

    public PercentageDiscount(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public float applyDiscount(float originalAmount) {
        return originalAmount * (1 - percentage / 100);
    }

    @Override
    public float getAmount() {
        return percentage;
    }
}
