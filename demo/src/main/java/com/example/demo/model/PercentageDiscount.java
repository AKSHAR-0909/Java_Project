package com.example.model;

public class PercentageDiscount implements Discount {
    private float percentage;

    public PercentageDiscount(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public float applyDiscount(float amount) {
        return amount * (1 - percentage / 100);
    }
}
