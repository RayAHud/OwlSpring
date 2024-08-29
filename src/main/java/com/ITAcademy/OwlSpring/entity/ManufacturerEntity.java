package com.ITAcademy.OwlSpring.entity;

import com.ITAcademy.OwlSpring.model.Manufacturer;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manufacturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;
    @Column(name = "name")
    private String name;

    //constructor without manufacturerId (to be auto generated)
    public ManufacturerEntity(String name) {
        this.name = name;
    }

    //constructor that takes a Manufacturer Object as its parameter.
    public ManufacturerEntity(Manufacturer manufacturer){
        this.manufacturerId = manufacturer.getManufacturerId();
        this.name = manufacturer.getName();
    }

    //Method that makes a manufacturer object from a manufacturer entity
    public Manufacturer createDTO(ManufacturerEntity manufacturerEntity){
        Manufacturer manufacturer = new Manufacturer(
                this.manufacturerId = manufacturerEntity.getManufacturerId(),
                this.name = manufacturerEntity.getName()
        );
        return manufacturer;
    }

}
