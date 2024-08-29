package com.ITAcademy.OwlSpring.entity;

import com.ITAcademy.OwlSpring.model.Car;
import com.ITAcademy.OwlSpring.model.CatalogModel;
import com.ITAcademy.OwlSpring.model.Vehicle;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class CarEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventoryIdNumber;
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long serialNumber;
    private String color;
    private Long manufacturer;
    private Long catalogModel;
    private Long numberOfWheels;
    private Long country;
    //constructor without inventoryIdNumber ( Both to be auto generated)

public CarEntity(Long serialNumber, String color, Long manufacturer, Long catalogModel, Long numberOfWheels, Long country) {
        this.serialNumber = serialNumber;
        this.color = color;
        this.manufacturer = manufacturer;
        this.catalogModel = catalogModel;
        this.numberOfWheels = numberOfWheels;
        this.country = country;
    }

}

