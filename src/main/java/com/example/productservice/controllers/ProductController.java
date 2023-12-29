package com.example.productservice.controllers;

import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void setProductService (@Qualifier("fakeStoreProductServiceImpl") ProductService productService){
        this.productService=productService;
    }

    //localhost:8000/product/12345

//    public String getProductById(@PathVariable("id") Long id){
//        return productService.getProductById(id);
//    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @GetMapping
    public List<GenericProductDto> getAllProducts(){

        return productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }
    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);

    }
    public void updateProductById(){

    }

}
