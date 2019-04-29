package com.youfan.dao;

import com.youfan.mapper.ProductTypeMapper;
import com.youfan.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTypeDao {
    @Autowired
    ProductTypeMapper productTypeMapper;

    /**
     * 插入
     * @param productType
     */
    public void insertProductType(ProductType productType){
        productTypeMapper.insertProductType(productType);
    }

    /**
     * 通过id查找
     * @param id
     * @return
     */
    public ProductType findProductTypeById(int id){
        return productTypeMapper.findProductTypeById(id);
    }

    /**
     * 查询所有
     * @return
     */
    public List<ProductType> listAllProductType(){
        return productTypeMapper.listAllProductType();
    }

    /**
     * 更新
     * @param productType
     */
    public void updateProductTypebyId(ProductType productType){
        productTypeMapper.updateProductTypebyId(productType);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteProductTypeById(int id){
        productTypeMapper.deleteProductTypeById(id);
    }
}
