package com.example.demo.config;

import com.example.demo.service.Discount;
import com.example.demo.service.FixedDiscount;
import com.example.demo.service.PercentageDiscount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DiscountConfig {

    @Bean
    @Primary
    public Discount fixedDiscount() {
        return new FixedDiscount();
    }

    @Bean
    public Discount percentageDiscount() {
        return new PercentageDiscount();
    }
}
