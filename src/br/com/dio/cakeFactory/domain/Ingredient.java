package br.com.dio.cakeFactory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Ingredient {
    protected String name;
    protected float quantity;
    protected String measurementUnit;

    public Ingredient(String name, float quantity, String measurementUnit) {
        this.name = name;
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
    }
}
