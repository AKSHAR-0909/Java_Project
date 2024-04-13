package com.example.demo.controller;

import com.example.demo.model.Discount;
import com.example.demo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/bookings/{bookingId}/applyDiscount")
    public ResponseEntity<?> applyDiscount(@PathVariable int bookingId, @RequestBody Discount discount) {
        try {
            discountService.applyDiscountToBooking(bookingId, discount);
            return ResponseEntity.ok("Discount applied successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to apply discount: " + e.getMessage());
        }
    }
}
