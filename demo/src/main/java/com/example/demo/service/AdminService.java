package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.model.Bookings;
import com.example.demo.model.Flight;
import com.example.demo.model.Person;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightService flightService;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    public List<Bookings> getAllBookings() {
        return bookingService.getAllBookings();
    }

    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }
}
