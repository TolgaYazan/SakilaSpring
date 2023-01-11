package com.uniyaz.sakila.rest;

import com.uniyaz.sakila.core.country.Country;
import com.uniyaz.sakila.core.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(path = "findAll", produces = MediaType.APPLICATION_PDF_VALUE)
    public List<Country> findAllCountry() {
        return countryService.findAll();
    }

    @GetMapping(path = "/findAllByName/{name}")
    public List<Country> findAllByNameCountry(@PathVariable String name) {
        return countryService.findAllByName(name);
    }

    @GetMapping(path = "/findById/{id}")
    public Optional<Country> findAllByIdCountry(@PathVariable Long id) {
        return countryService.findById(id);
    }

    @PostMapping("/save")
    public List<Country> save(@RequestBody Country country){
        return countryService.save(country);
    }
}