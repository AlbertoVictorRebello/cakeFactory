package br.com.dio.cakeFactory.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public final class CakeRecipeIngredientLists {

    public static List<Ingredient> getIngredientList(String cakeName) {
        List<Ingredient> recipeIngredientList = new LinkedList<>();

        switch(cakeName) {
            case "Super Easy Brownie":
                recipeIngredientList.add(new Ingredient("cocoa powder", 1/3F, "cup"));
                recipeIngredientList.add(new Ingredient("wholemeal", 1/2F, "cup flour"));
                recipeIngredientList.add(new Ingredient("egg", 2.0F, "unit"));
                recipeIngredientList.add(new Ingredient("extra virgin olive oil", 1/2F, "cup"));
                recipeIngredientList.add(new Ingredient("brown sugar", 3/4F, "cup"));
                recipeIngredientList.add(new Ingredient("raspberrie", 100.0F, "gram"));
                recipeIngredientList.add(new Ingredient("whisky", 100.0F, "ml"));
                break;
        }
        return recipeIngredientList;
    }
}
