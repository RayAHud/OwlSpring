package com.ITAcademy.OwlSpring.entity;

import com.ITAcademy.OwlSpring.model.CatalogModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "catalog_model")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long modelId;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "manufacturer")
    private Long manufacturer;
    @Column(name = "description")
    private String description;
    @Column(name = "vehicle_type")
    private String vehicleType;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Long countryId;

    //constructor without modelId (to be auto generated)
    public CatalogModelEntity(String modelName, Long manufacturer, String description, String vehicleType) {
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.description = description;
        this.vehicleType = vehicleType;
//        this.countryEntity = countryEntity;
    }
    public CatalogModelEntity(String modelName, Long manufacturer, String description, String vehicleType, Long countryId) {
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.description = description;
        this.vehicleType = vehicleType;
        this.countryId = countryId;
    }

    //constructor that takes a CatalogModel Object as its parameter.
//    public CatalogModelEntity(CatalogModel catalogModel){
//        this.modelId = catalogModel.getModelID();
//        this.modelName = catalogModel.getModelName();
//        this.manufacturerId = catalogModel.getManufacturer().getId();
//        this.description = catalogModel.getDescription();
//        this.vehicleType = catalogModel.getVehicleType();

//    public CatalogModel createCatalogModel(){
//        return new CatalogModel(this.modelId, this.modelName, this.getManufacturerId(), this.description, this.vehicleType)
//        }
//    }
}
