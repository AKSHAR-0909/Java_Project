package com.example.demo.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    
    // private int userId;
    private int flightId;
    private LocalDate bookingDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    // private Discount discount;  
    // Add discount field


    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return user.getUserId();
    }

    public void setUserId(int userId) {
        user.setUserId(userId);
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // Discount feature in Booking Class
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public float calculateTotal(float originalAmount) {
        if (discount != null) {
            return discount.applyDiscount(originalAmount);
        }
        return originalAmount;
    }
}
