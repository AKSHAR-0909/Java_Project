package com.example.demo.model;

import jakarta.persistence.OneToMany;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.JoinColumn;
import java.util.List;
import jakarta.persistence.Entity;

@Entity
public class Users extends Person {

    // @ManyToOne
    // @JoinColumn(name = "user_id")
    // private Person person;

    // public Person getPerson() {
    //     return person;
    // }

    // public void setPerson(Person person) {
    //     this.person = person;
    // }


    @OneToMany(mappedBy = "user")
    private List<Bookings> bookings;

    public List<Bookings> getBookings() {
        return bookings;
    }

    public void setBookings(List<Bookings> bookings) {
        this.bookings = bookings;
    }

    public Bookings bookFlight(Flight flight) {
        Bookings booking = new Bookings();
        booking.setUserId(this.getUserId());
        booking.setFlightId(flight.getFlightId());
        // Set other booking details
        return booking;
    }

    public void cancelBooking(int bookingId) {
        // Implementation
    }

    public List<Bookings> viewBookedFlights() {
        return this.bookings;
    }

}
