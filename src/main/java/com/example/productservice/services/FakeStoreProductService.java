package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.thirdParyClients.FakeStoreClientAdapter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductService implements ProductService{
    private FakeStoreClientAdapter fakeStoreAdapter;
    FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter){
        this.fakeStoreAdapter=fakeStoreAdapter;
    }

    private static GenericProductDto convertToGenericProductDto (FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDto;
    }

    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
    }

    public List<GenericProductDto> getAllProducts(){
        List<FakeStoreProductDto> fakeStoreProductDtos=fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> result=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }
    public GenericProductDto deleteProductById(long id){
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }
    public GenericProductDto createProduct(GenericProductDto genericProductDto){
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }
    public void updateProductById(){

    }
}
