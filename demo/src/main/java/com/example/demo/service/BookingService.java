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

    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Bookings getBookingById(int id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Bookings saveBooking(Bookings booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }
}
