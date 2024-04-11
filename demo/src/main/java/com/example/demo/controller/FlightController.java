package com.example.demo.controller;

import com.example.demo.model.Flight;
import com.example.demo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.*;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public String GetFlights(Model model){
        List<Flight> flights = flightService.getAllFlights();
        model.addAttribute("flights", flights);
        return "flights";
    }

    @GetMapping("/flights/{id}")
    public String GetOneFlight(@PathVariable int id,Model model){
        Flight flights = flightService.getFlightById(id);
        model.addAttribute("flights", flights);
        return "flights";
    }

}