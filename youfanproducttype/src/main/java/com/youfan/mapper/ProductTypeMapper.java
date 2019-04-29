package com.youfan.mapper;

import com.youfan.model.ProductType;

import java.util.List;

public interface ProductTypeMapper {
    public void insertProductType(ProductType productType);
    public ProductType findProductTypeById(int id);
    public List<ProductType> listAllProductType();
    public void updateProductTypebyId(ProductType productType);
    public void deleteProductTypeById(int id);
}
