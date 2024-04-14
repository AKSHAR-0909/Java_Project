package com.example.demo.service;

public class PercentageDiscount implements Discount {
    private static final float PERCENTAGE = 0.10f;

    @Override
    public float applyDiscount(float amount) {
        if (amount < 500.0f) {
            return amount * (1 - PERCENTAGE);
        } else {
            return amount - 50.0f;
        }
    }
}