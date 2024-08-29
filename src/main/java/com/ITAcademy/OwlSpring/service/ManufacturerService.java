package com.ITAcademy.OwlSpring.service;

import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
import com.ITAcademy.OwlSpring.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    List<Manufacturer> listManufacturers();
    Manufacturer manufacturerDetailById(long id);
    Manufacturer createManufacturerEntity (Manufacturer manufacturer);
    Manufacturer updateManufacturer (long id, Manufacturer manufacturer);
    void deleteManufacturer(long id);
}
