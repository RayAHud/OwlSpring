package com.ITAcademy.OwlSpring.controller;

import com.ITAcademy.OwlSpring.entity.CountryEntity;
import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
import com.ITAcademy.OwlSpring.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CountryController {
    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public ResponseEntity<List<CountryEntity>> getAllCountries(){
        try {
            List<CountryEntity> countries = new ArrayList<>();
            countryRepository.findAll().forEach(countries::add);
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
