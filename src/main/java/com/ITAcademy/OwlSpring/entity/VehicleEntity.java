package com.ITAcademy.OwlSpring.entity;

import com.ITAcademy.OwlSpring.model.CatalogModel;
import com.ITAcademy.OwlSpring.model.Vehicle;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventoryIdNumber;
    private long serialNumber;
    private String color;
    private Long catalogModelId;

    //constructor without inventoryIdNumber (to be auto generated)
//    public VehicleEntity(long serialNumber, String color, Long catalogModelId) {
//        this.serialNumber = serialNumber;
//        this.color = color;
//        this.catalogModelId = catalogModelId;
//    }

    //constructor that takes a Vehicle Object as its parameter.
//    public VehicleEntity(Vehicle vehicle){
//        this.inventoryIdNumber = vehicle.getInventoryIdNumber();
//        this.serialNumber = vehicle.getSerialNumber();
//        this.color = vehicle.getColor();
//        this.catalogModelId = vehicle.getCatalogModel().getModelID();
//    }
}
