package com.example.productservice.controllers;

import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Constructor Injection
    private ProductService productService;

//    ProductController(ProductService productService){
//        this.productService=productService;
//    }
//
    @Autowired
    public void setProductService (ProductService productService){
        this.productService=productService;
    }
    //localhost:8000/product/12345
    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @GetMapping
    public void getAllProduct(){

    }
    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }
    public void createProduct(){

    }
    public void updateProductById(){

    }

}
