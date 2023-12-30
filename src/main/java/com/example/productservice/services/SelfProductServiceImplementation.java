package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("selfProductServiceImpl")
public class SelfProductServiceImplementation implements ProductService{


    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    public List<GenericProductDto> getAllProducts(){
        return null;
    }
    public GenericProductDto deleteProductById(long id){
        return null;
    }
    public GenericProductDto createProduct(GenericProductDto genericProductDto){
        return null;

    }
    public void updateProductById(){
    }
}
