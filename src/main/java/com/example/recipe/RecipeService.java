package com.example.recipe;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

public class RecipeService implements RecipeRepository {

    private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();
    int uniqRecipeId = 6;

    public RecipeService() {
        recipeBook.put(1,
                new Recipe(1, "Pasta", "veg",
                        Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
        recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
        recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
        recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
        recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
    }

    @Override
    public ArrayList<Recipe> getRecipes() {
        Collection<Recipe> recipeCollection = recipeBook.values();
        ArrayList<Recipe> recipes = new ArrayList<>(recipeCollection);
        return recipes;
    }

    @Override
    public Recipe getRecipe(int recipeId) {
        if (recipeBook.get(recipeId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return recipeBook.get(recipeId);
    }

    @Override
    public Recipe addRecipe(Recipe recipeObj) {
        recipeObj.setRecipeId(uniqRecipeId);
        recipeBook.put(uniqRecipeId, recipeObj);
        uniqRecipeId += 1;
        return recipeObj;
    }

    @Override
    public Recipe updateRecipe(int recipeId, Recipe recipeObj) {
        Recipe existingRecipe = recipeBook.get(recipeId);

        if (existingRecipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (recipeObj.getRecipeName() != null) {
            existingRecipe.setRecipeName(recipeObj.getRecipeName());
        }

        if (recipeObj.getRecipeType() != null) {
            existingRecipe.setRecipeType(recipeObj.getRecipeType());
        }

        if (recipeObj.getIngredients() != null) {
            existingRecipe.setIngredients(recipeObj.getIngredients());
        }

        return existingRecipe;
    }

    @Override
    public void deleteRecipe(int recipeId) {
        Recipe recipeObj = recipeBook.get(recipeId);
        if (recipeObj == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            recipeBook.remove(recipeId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}