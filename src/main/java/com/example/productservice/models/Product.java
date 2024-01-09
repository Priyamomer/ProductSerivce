package com.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseModel{

    private String title;
    private String description;
    @OneToOne(cascade = {jakarta.persistence.CascadeType.REMOVE, jakarta.persistence.CascadeType.PERSIST})
    @JoinColumn
    //@JoinColumn(name = "price_id")
    private Price price;
    private String image;
    @ManyToOne
    private Category category;

}
