package com.youfan.controller;

import com.youfan.model.ProductType;
import com.youfan.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @RequestMapping(value = "/toInsertProductType",method = RequestMethod.GET)
    public String toInsertProductType() {
        return "addProductType";
    }

    @RequestMapping(value = "/insertProductType",method = RequestMethod.POST)
    public void insertProductType(ProductType productType){
        productTypeService.insertProductType(productType);
    }


    @RequestMapping("/findProductTypeById")
    public String findProductTypeById(int id,Model model){
        ProductType productType = productTypeService.findProductTypeById(id);
        model.addAttribute("productType",productType);
        return "findProductType";
    }

    @RequestMapping("/listAllProductType")
    public ModelAndView listAllProductType(){
        ModelAndView modelAndView = new ModelAndView();
        List<ProductType> productTypeList = productTypeService.listAllProductType();
        modelAndView.addObject("productTypeList",productTypeList);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/toProductUpdate",method = RequestMethod.GET)
    public String toProductUpdate(int id,Model model) {
        ProductType productType = productTypeService.findProductTypeById(id);
        model.addAttribute("productType",productType);
        return "updateProductType";
    }
    @RequestMapping("/updateProductTypebyId")
    public void updateProductType(ProductType productType,HttpServletRequest request, HttpServletResponse response)throws Exception{
        productTypeService.updateProductTypebyId(productType);
        request.getRequestDispatcher("/listAllProductType").forward(request,response);
    }

    @RequestMapping(value = "/deleteProductTypeById")
    public void deleteProductTypeById(int id, HttpServletRequest request, HttpServletResponse response)throws Exception{
        productTypeService.deleteProductTypeById(id);
        request.getRequestDispatcher("/listAllProductType").forward(request,response);
    }
}
