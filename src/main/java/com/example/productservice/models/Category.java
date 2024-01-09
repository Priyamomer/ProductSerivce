package com.example.productservice.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;
    public Category(String name){
        this.name=name;
    }
}
