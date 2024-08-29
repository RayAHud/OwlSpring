package com.ITAcademy.OwlSpring.model;

import com.ITAcademy.OwlSpring.entity.ManufacturerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {
    private Long manufacturerId;
    private String name;

    public Manufacturer(ManufacturerEntity manufacturerEntity){
        this.manufacturerId = manufacturerEntity.getManufacturerId();
        this.name = manufacturerEntity.getName();
    }
//    public Optional<Manufacturer> manufacturer(Optional<ManufacturerEntity> manufacturerEntity){
//        this.id = manufacturerEntity.getManufacturerId();
//        this.name = manufacturerEntity.getName();
//    }

    private void streamManufacturer(List<Manufacturer> manufacturerList){
        manufacturerList.stream().map(ManufacturerEntity::new).collect(Collectors.toList());
    }



}
