package org.venkatesh.microservice2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.venkatesh.microservice2.model.Country;
import org.venkatesh.microservice2.service.CountryService;

import java.util.Collection;

@RestController
@RequestMapping("/country")
public class CountryController {


    private final  CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/add-country")
    public String addCourse(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @GetMapping("/get-data")
    public Collection<Object> getAllCountries(){
        return countryService.getAllCountries();
    }
}
