package com.cognizant.spring_learn.jwt_handson.jwt_handson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public String getCountries() {
        return "India";
    }
}
