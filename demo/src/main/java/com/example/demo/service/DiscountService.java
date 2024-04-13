package com.example.demo.service;

import com.example.demo.model.Bookings;
import com.example.demo.model.Discount;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public void applyDiscountToBooking(Bookings booking, Discount discount) {

        // Apply the discount to the booking
        // Calculate the discounted price and update the booking

        // Check if the booking and discount are not null
        if (booking != null && discount != null) {
            // Calculate the discounted price based on the discount
            double discountedPrice = calculateDiscountedPrice(booking.getPrice(), discount.getAmount());

            // Update the booking with the discounted price and mark it as discounted
            booking.setPrice(discountedPrice);
            // Update other fields as needed
            // booking.setDiscountApplied(true);

            // Optionally, you can log or perform any other operations here

            // Print a message indicating that the discount has been applied
            System.out.println("Discount applied to booking: " + booking.getBookingId());
        } else {
            // If either the booking or discount is null, print an error message
            System.out.println("Failed to apply discount: Booking or discount is null");
        }
    }

    // Method to calculate the discounted price based on the original price and discount amount
    private double calculateDiscountedPrice(double originalPrice, double discountAmount) {
        return originalPrice - discountAmount;
    }
}
