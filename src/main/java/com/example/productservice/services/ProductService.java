package com.example.productservice.services;

import com.example.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    //String getProductById(Long id);

    GenericProductDto getProductById(Long id);

    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    void updateProductById();

}
