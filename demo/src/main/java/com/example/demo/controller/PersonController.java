package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;



@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/login")
    public String renderLoginPage(){
        return "login"; //create a login.html page, that takes (email,password) as input in a form
    }

    @PostMapping("/login")
    public String login(@PathVariable String email,@PathVariable String password){
        // implement login logic here
        return "home"; // create a home.html page and render it only if the login is a success
    }

    @GetMapping("/signup")
    public String renderSignupPage(){
        return "signup"; //create a signup.html page, that takes (email,password,name,phone_number,address) as input in a form
    }

    @PostMapping("/signup")
    public String signup(@PathVariable String email,@PathVariable String password
    ,@PathVariable String name,@PathVariable int phone_number,@PathVariable String address){
        // implement signup logic here
        return "home"; // create a home.html page and render it only if the signup is a success
    }

    @GetMapping("/profile/{id}")
    public String getPersonById(@PathVariable int id, Model model) {
        Person user = personService.getPersonById(id);
        model.addAttribute("user", user);
        return "profile"; // This will render profile.html template
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id) {
        // Implement delete logic here
        personService.deletePerson(id);
        return ResponseEntity.ok("Person deleted successfully");
    }
    

}
