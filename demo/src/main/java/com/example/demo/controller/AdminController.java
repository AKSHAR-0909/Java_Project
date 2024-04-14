package com.example.demo.controller;

import com.example.demo.model.Bookings;
import com.example.demo.model.Flight;
import com.example.demo.model.Person;
import com.example.demo.model.Users;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

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
}
