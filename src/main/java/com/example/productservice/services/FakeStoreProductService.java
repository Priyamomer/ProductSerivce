package com.example.productservice.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public String getProductById(Long id){
        return "Hello Hello !! Product id : "+id;
    }
    public void getAllProducts(){

    }
    public void deleteProductById(){

    }
    public void createProduct(){

    }
    public void updateProductById(){

    }
}
