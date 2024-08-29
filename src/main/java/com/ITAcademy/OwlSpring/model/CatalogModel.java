package com.ITAcademy.OwlSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatalogModel {
    private Long modelID;
    private String modelName;
    private Long manufacturer;
    private String description;
    private String vehicleType;

    //  Class Methods
    public List<CatalogModel> generateTenCatalogModels(){
        List<CatalogModel> catalogModelList = new ArrayList<>();

        return catalogModelList;
    }

}
