package com.example.demo.controller;

import com.example.demo.model.Bookings;
import com.example.demo.model.Flight;
import com.example.demo.model.Person;
import com.example.demo.model.Users;
import com.example.demo.service.AdminService;
import com.example.demo.service.BookingService;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import com.example.demo.service.FlightService;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired    
    private BookingService bookingService;
    @Autowired
    private PersonService personService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        List<Users> users = adminService.getAllUsers();
        List<Person> persons = adminService.getAllPersons();
        List<Bookings> bookings = adminService.getAllBookings();
        List<Flight> flights = adminService.getAllFlights();

        model.addAttribute("users", users);
        model.addAttribute("persons", persons);
        model.addAttribute("bookings", bookings);
        model.addAttribute("flights", flights);

        return "admin";
    }
    @DeleteMapping("/delete{type}/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable String type, @PathVariable int id) {
        switch (type) {
            case "user":
                userService.deleteUser(id);
                break;
            case "person":
                personService.deletePerson(id);
                break;
            case "booking":
                bookingService.deleteBooking(id);
                break;
            case "flight":
                flightService.deleteFlight(id);
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid type provided");
        }
        return ResponseEntity.ok("Entry deleted successfully");
    }
}