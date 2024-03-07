package com.example.recipe;

import java.util.*;

public interface RecipeRepository {
    ArrayList<Recipe> getRecipes();

    Recipe getRecipe(int recipeId);

    Recipe addRecipe(Recipe recipeObj);

    Recipe updateRecipe(int recipeId, Recipe recipeObj);

    void deleteRecipe(int recipeId);

}