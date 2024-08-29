package com.ITAcademy.OwlSpring.service;




import com.ITAcademy.OwlSpring.model.CatalogModel;

import java.util.List;

public interface CatalogModelService {
    List<CatalogModel> listCatalogModels();
    CatalogModel atalogModelDetailById(long id);
    CatalogModel createCatalogModelEntity (CatalogModel catalogModel);
    CatalogModel updateCatalogModel (long id, CatalogModel catalogModel);
    void deleteCatalogModel(long id);

}
