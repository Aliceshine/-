package com.youfan.service;

import com.youfan.dao.ProductTypeDao;
import com.youfan.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    ProductTypeDao productTypeDao;

    public void insertProductType(ProductType productType){
        productTypeDao.insertProductType(productType);
    }
    public ProductType findProductTypeById(int id){
        return productTypeDao.findProductTypeById(id);
    }

    public List<ProductType> listAllProductType(){
        return productTypeDao.listAllProductType();
    }
    public void updateProductTypebyId(ProductType productType){
        productTypeDao.updateProductTypebyId(productType);
    }

    public void deleteProductTypeById(int id){
        productTypeDao.deleteProductTypeById(id);
    }
}
