package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Override
    //<S extends Product> S save(S entity);
    List<Product> findAll();
    List<Product> findAllByTitle(String title);
    List<Product> findAllByTitleAndDescription(String title,String desc);
    @Override
    <S extends Product> List<S> findAll(Example<S> example);
    //<S extends Product> this is generic type declaration, It's stating that the method is
    //Generic and can work with any type of 'S' that extends or is subtype of 'Product'
    //List<S> is specifying the return type
    //findALL is the method name
    //Example<S> this is a parameterized type representing an example instance of type 'S'
    //The example is created using an instance of the entity with
    // set properties, and the method generates a dynamic query to find
    // entities whose non-null properties match the values in the example.

    List<Product> findAllByPrice_ValueLessThan(Integer x);

    //@Query(value = "select * from product where id = 1", nativeQuery = true)
    List<Product> findAllByPrice_ValueBetween(double x, double y);

    List<Product> findAllByCategory_Name(String name);
}
