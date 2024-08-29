package com.ITAcademy.OwlSpring.controller;

import com.ITAcademy.OwlSpring.entity.CarEntity;
import com.ITAcademy.OwlSpring.entity.CatalogModelEntity;
import com.ITAcademy.OwlSpring.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarRepository carRepository;
    //GET retrieve all vehicles
    @GetMapping("/vehicles")
    public ResponseEntity<List<CarEntity>> getAllVehicles(){
        try {
            List<CarEntity> carEntities= new ArrayList<>();
            carRepository.findAll().forEach(carEntities::add);
            return new ResponseEntity<>(carEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //GET retrieve Car by id
    @GetMapping("/vehicles/{id}")
    public ResponseEntity<CarEntity> getVehicleById(@PathVariable("id") long id) {
        Optional<CarEntity> carDetail = carRepository.findById(id);

        if (carDetail.isPresent()){
            return new ResponseEntity<>(carDetail.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //POST create new Car
    //todo POST does not create a new serial number
    @PostMapping("/vehicles")
    public ResponseEntity<CarEntity> createVehicle(@RequestBody CarEntity carEntity) {
        try {
            CarEntity _carEntity = carRepository.save(new CarEntity(carEntity.getSerialNumber(),
                    carEntity.getColor(),
                    carEntity.getManufacturer(),
                    carEntity.getCatalogModel(),
                    carEntity.getNumberOfWheels(),
                    carEntity.getCountry()));
            return new ResponseEntity<>(_carEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //update a Car by id
    @PutMapping("/vehicles/{id}")
    public ResponseEntity<CarEntity> updateVehicle(@PathVariable("id") long id, @RequestBody CarEntity carEntity){
        Optional<CarEntity> vehicleDetail = carRepository.findById(id);

        if (vehicleDetail.isPresent()){
            CarEntity _vehicleEntity = vehicleDetail.get();
//            _vehicleEntity.setSerialNumber(carEntity.getSerialNumber());
            _vehicleEntity.setColor(carEntity.getColor());
            _vehicleEntity.setManufacturer(carEntity.getManufacturer());
            _vehicleEntity.setCatalogModel(carEntity.getCatalogModel());
            _vehicleEntity.setNumberOfWheels(carEntity.getNumberOfWheels());
            _vehicleEntity.setCountry(carEntity.getCountry());
            _vehicleEntity.setSerialNumber(carEntity.getSerialNumber());
            return new ResponseEntity<>(carRepository.save(_vehicleEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //DELETE a car by id
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<HttpStatus> deleteVehicle(@PathVariable("id") long id) {
        try {
            carRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //todo DELETE all cars
}
