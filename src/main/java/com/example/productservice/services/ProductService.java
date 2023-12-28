package com.example.productservice.services;

public interface ProductService {
    String getProductById(Long id);
    void getAllProducts();
    void deleteProductById();
    void createProduct();
    void updateProductById();

}
