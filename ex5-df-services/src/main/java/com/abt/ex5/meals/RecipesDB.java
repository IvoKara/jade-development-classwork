package com.abt.ex5.meals;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipesDB {
    private static ArrayList<CookRecipe> recipes;

    static {
        recipes = new ArrayList<CookRecipe>(
                Arrays.asList(
                        new CookRecipe("Apple Pie"),
                        new CookRecipe("Chicken Soup"),
                        new CookRecipe("Green Salad"),
                        new CookRecipe("Sushi")));

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>(
                Arrays.asList(
                        new Ingredient("frozen apples", "1", "package"),
                        new Ingredient("sugar", "2/3", "cup"),
                        new Ingredient("salt", "1", "teaspoon"),
                        new Ingredient("large eggs", "2", ""),
                        new Ingredient("butter", "2/3", "cup")));

        ArrayList<String> instructions = new ArrayList<String>(
                Arrays.asList(
                        "Preheat oven",
                        "Mix sugar ...",
                        "Stir in flour ...",
                        "Bake"));

        for (CookRecipe recipe : recipes) {
            recipe.addIngredients(ingredients);
            recipe.addInstructions(instructions);
        }
    }

    public static ArrayList<CookRecipe> getAll() {
        return recipes;
    }
}
