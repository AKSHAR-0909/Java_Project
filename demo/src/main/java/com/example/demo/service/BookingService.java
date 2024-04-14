package com.example.demo.service;

import com.example.demo.model.Bookings;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private Discount fixedDiscountService;

    @Autowired
    private Discount percentageDiscountService;

    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Bookings getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Bookings saveBooking(Bookings booking) {
        float totalPrice = booking.getTotalPrice();
        Discount selectedDiscount = totalPrice < 500 ? percentageDiscountService : fixedDiscountService;
        
        // Check if discount has been applied already
        if (!booking.isDiscountApplied()) {
            float discountedPrice = selectedDiscount.applyDiscount(totalPrice);
            booking.setTotalPrice(discountedPrice);
            booking.setDiscountApplied(true); // Update discount status
        }
        
        return bookingRepository.save(booking);
    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }
}
