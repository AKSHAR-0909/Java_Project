package com.example.demo.model;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private float discountPercentage;

    public PercentageDiscountStrategy(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public float applyDiscount(float price) {
        return price * (discountPercentage / 100);
    }
}
