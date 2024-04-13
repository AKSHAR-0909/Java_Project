package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Discount;
import com.example.demo.service.DiscountService;
import com.example.demo.service.BookingService; // Import BookingService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @Autowired
    private BookingService bookingService; // Autowire BookingService

    @PostMapping("/bookings/{bookingId}/applyDiscount")
    public ResponseEntity<?> applyDiscount(@PathVariable int bookingId, @RequestBody Discount discount) {
        try {
            // Fetch the Booking object based on the ID
            Booking booking = bookingService.getBookingById(bookingId);
            // Pass the Booking object to the service method
            discountService.applyDiscountToBooking(booking, discount);
            return ResponseEntity.ok("Discount applied successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to apply discount: " + e.getMessage());
        }
    }
}
