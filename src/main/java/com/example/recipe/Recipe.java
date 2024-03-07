package com.example.recipe;

import java.util.*;

public class Recipe {
    private int recipeId;
    private String recipeName;
    private String recipeType;
    private List<String> ingredients;

    public Recipe(int recipeId, String recipeName, String recipeType, List<String> ingredients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.ingredients = ingredients;
    }

    public void setRecipeId(int id) {
        this.recipeId = id;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeName(String name) {
        this.recipeName = name;
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public void setRecipeType(String type) {
        this.recipeType = type;
    }

    public String getRecipeType() {
        return this.recipeType;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

}