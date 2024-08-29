package com.ITAcademy.OwlSpring.service;

import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
import com.ITAcademy.OwlSpring.model.Manufacturer;
import com.ITAcademy.OwlSpring.repository.ManufacturerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{
    private ManufacturerRepository manufacturerRepository;
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository){
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> listManufacturers() {
        List<Manufacturer> manufacturerList = StreamSupport.stream(manufacturerRepository.findAll().spliterator(), false)
                .map(Manufacturer::new).collect(Collectors.toList());
        return manufacturerList;
    }

    @Override
    public Manufacturer manufacturerDetailById(long id) {
        ManufacturerEntity manufacturerEntity = manufacturerRepository.findById(id).get();
        Manufacturer manufacturerDetail = new Manufacturer(manufacturerEntity);
        return manufacturerDetail;
    }

    @Override
    public Manufacturer createManufacturerEntity(Manufacturer manufacturer) {
        ManufacturerEntity manufacturerEntity = manufacturerRepository.save(new ManufacturerEntity(manufacturer));
        Manufacturer _manufacturer = new Manufacturer(manufacturerEntity);
        return _manufacturer;
    }

    @Override
    public Manufacturer updateManufacturer(long id, Manufacturer manufacturer) {

        Optional<ManufacturerEntity> manufacturerEntity = manufacturerRepository.findById(id);

        if (manufacturerEntity.isPresent()) {
            ManufacturerEntity _manufacturerEntity = manufacturerRepository.save(new ManufacturerEntity(manufacturer));
            return manufacturer;
        } else {
            return null;
        }
    }

    @Override
    public void deleteManufacturer(long id) {
        manufacturerRepository.deleteById(id);

    }
}
