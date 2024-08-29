package com.ITAcademy.OwlSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends Vehicle{

    private int numberOfWheels;

    public Car(long inventoryIdNumber, long serialNumber, String color, CatalogModel catalogModel, int numberOfWheels) {
        super(inventoryIdNumber, serialNumber, color, catalogModel);
        this.numberOfWheels = numberOfWheels;
    }
}
