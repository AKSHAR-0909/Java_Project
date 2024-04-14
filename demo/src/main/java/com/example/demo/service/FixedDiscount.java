package com.example.demo.service;

public class FixedDiscount implements Discount {
    private static final float FIXED_AMOUNT = 50.0f;

    @Override
    public float applyDiscount(float amount) {
        return amount - FIXED_AMOUNT;
    }
}
