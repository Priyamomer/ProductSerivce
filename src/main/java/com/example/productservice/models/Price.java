package com.example.productservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Price extends BaseModel{
    private String currency;
    private boolean haha;
    private String currency2;
    private double value;
    public Price(String currency,double value){
        this.currency=currency;
        this.value=value;
    }
}
