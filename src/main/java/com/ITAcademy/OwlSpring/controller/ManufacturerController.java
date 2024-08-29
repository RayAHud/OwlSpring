package com.ITAcademy.OwlSpring.controller;

import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;

import com.ITAcademy.OwlSpring.model.Manufacturer;
import com.ITAcademy.OwlSpring.repository.ManufacturerRepository;

import com.ITAcademy.OwlSpring.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://8081")
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ManufacturerController {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerService manufacturerService;
    public ManufacturerController(ManufacturerRepository manufacturerRepository, ManufacturerService manufacturerService) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerService = manufacturerService;
    }
    /*  GET retrieve all manufacturers  */
//    @PreAuthorize("hasRole('USER')")
    @GetMapping("/manufacturers")
    public ResponseEntity<List<Manufacturer>> getAllManufacturers(){
        try {
            List<Manufacturer> manufacturers= manufacturerService.listManufacturers();
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*  GET retrieve manufacturer by id */
    @GetMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable("id") long id) {

        Manufacturer manufacturerDetail = manufacturerService.manufacturerDetailById(id);

        if (manufacturerDetail != null){
            return new ResponseEntity<>(manufacturerDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /*  POST create new manufacturer    */
//    @PreAuthorize("hasRole('USER')")
    @PostMapping("/manufacturers")
    public ResponseEntity<Manufacturer> postManufacturer(@RequestBody Manufacturer manufacturer) {
        try {
            Manufacturer _manufacturer = manufacturerService.createManufacturerEntity(manufacturer);
            return new ResponseEntity<>(_manufacturer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*  PUT update a manufacturer by id */
    @PutMapping("/manufacturers/{id}")
    public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable("id") long id, @RequestBody Manufacturer manufacturer){
        try{
            Manufacturer _manufacturer = manufacturerService.updateManufacturer(id, manufacturer);
            return new ResponseEntity<>(_manufacturer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*  DELETE a manufacturer by id */
    @DeleteMapping("/manufacturers/{id}")
    public ResponseEntity<HttpStatus> deleteManufacturer(@PathVariable("id") long id) {
        try {
            manufacturerService.deleteManufacturer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //todo DELETE all manufacturers
}
