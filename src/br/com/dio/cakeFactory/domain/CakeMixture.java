package br.com.dio.cakeFactory.domain;


import lombok.Data;

import java.util.LinkedList;

@Data
public class CakeMixture extends Cake{

    public CakeMixture(String cakeName) {
        // Setting the cake name
        this.name = cakeName;

        // Populating the ingredient List
        this.ingredients.addAll(CakeRecipeIngredientLists.getIngredientList(cakeName));

        //Setting the cooking temperature
        this.preheatOvenTemperatureCelsiusDegree = 170F;

        //Setting the baking time
        this.bakingTimeInMinutes = 18;

    }
}
