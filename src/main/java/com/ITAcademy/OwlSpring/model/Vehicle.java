package com.ITAcademy.OwlSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//todo experiment with Vehicle as an abstract class.
public class Vehicle {
    private Long inventoryIdNumber;
    private Long serialNumber;
    private String color;
    private CatalogModel catalogModel;

}
