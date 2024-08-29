package com.ITAcademy.OwlSpring.controller;

import com.ITAcademy.OwlSpring.entity.CatalogModelEntity;
import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
import com.ITAcademy.OwlSpring.repository.CatalogModelRepository;
import com.ITAcademy.OwlSpring.service.CatalogModelService;
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
public class CatalogModelController {
    @Autowired
    CatalogModelRepository catalogModelRepository;
    @Autowired
    CatalogModelService catalogModelService;
    //GET retrieve all catalogModels
    @GetMapping("/catalog_models")
    public ResponseEntity<List<CatalogModelEntity>> getAllCatalogModels(){
        try {
            List<CatalogModelEntity> catalogModelEntities= new ArrayList<>();
            catalogModelRepository.findAll().forEach(catalogModelEntities::add);
            return new ResponseEntity<>(catalogModelEntities, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //GET retrieve catalogModel by id
    @GetMapping("/catalog_models/{id}")
    public ResponseEntity<CatalogModelEntity> getCatalogModelById(@PathVariable("id") long id) {
        Optional<CatalogModelEntity> catalogModelDetail = catalogModelRepository.findById(id);

        if (catalogModelDetail.isPresent()){
            return new ResponseEntity<>(catalogModelDetail.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //POST create new catalogModel
    @PostMapping("/catalog_models")
    public ResponseEntity<CatalogModelEntity> createCatalogModel(@RequestBody CatalogModelEntity catalogModelEntity) {
        try {
            CatalogModelEntity _catalogModelEntity = catalogModelRepository.save(new CatalogModelEntity(
                    catalogModelEntity.getModelName(),
                    catalogModelEntity.getManufacturer(),
                    catalogModelEntity.getDescription(),
                    catalogModelEntity.getVehicleType(),
                    catalogModelEntity.getCountryId()
            ));
            return new ResponseEntity<>(_catalogModelEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //PUT update a catalogModel by id
    @PutMapping("/catalog_models/{id}")
    public ResponseEntity<CatalogModelEntity> updateCatalogModel(@PathVariable("id") long id, @RequestBody CatalogModelEntity catalogModelEntity){
        Optional<CatalogModelEntity> catalogModelDetail = catalogModelRepository.findById(id);

        if (catalogModelDetail.isPresent()){
            CatalogModelEntity _catalogModelEntity = catalogModelDetail.get();
            _catalogModelEntity.setModelName(catalogModelEntity.getModelName());
            _catalogModelEntity.setManufacturer(catalogModelEntity.getManufacturer());
            _catalogModelEntity.setDescription(catalogModelEntity.getDescription());
            _catalogModelEntity.setVehicleType(catalogModelEntity.getVehicleType());
            _catalogModelEntity.setCountryId(catalogModelEntity.getCountryId());
            return new ResponseEntity<>(catalogModelRepository.save(_catalogModelEntity), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //DELETE a catalogModel by id
    @DeleteMapping("/catalog_models/{id}")
    public ResponseEntity<HttpStatus> deleteCatalogModel(@PathVariable("id") long id) {
        try {
            catalogModelRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //todo DELETE all catalogModels

}
