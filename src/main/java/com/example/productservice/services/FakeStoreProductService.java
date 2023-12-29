package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.dtos.GenericProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
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
//    public String getProductById(Long id){
//        return "Hello Hello !! Product id : "+id;
//    }
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductUrl="https://fakestoreapi.com/products";
    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
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

        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.getForEntity(getProductUrl+"/"+id, FakeStoreProductDto.class);
        if(responseEntity.getBody()==null){
            throw new ProductNotFoundException("Product with id :"+id+" doesn't exist.");
        }
        return convertToGenericProductDto(responseEntity.getBody());
    }

    public List<GenericProductDto> getAllProducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity=restTemplate.getForEntity(getProductUrl,FakeStoreProductDto[].class);
        List<GenericProductDto> result=new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos=List.of(responseEntity.getBody());
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtos){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }
    public GenericProductDto deleteProductById(long id){
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback=restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor=
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.execute(getProductUrl+"/"+id, HttpMethod.DELETE,requestCallback,responseExtractor,id);
        return convertToGenericProductDto(responseEntity.getBody());
    }
    public GenericProductDto createProduct(GenericProductDto genericProductDto){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.postForEntity(getProductUrl, genericProductDto, FakeStoreProductDto.class);
        return convertToGenericProductDto((responseEntity.getBody()));
    }
    public void updateProductById(){

    }
}
