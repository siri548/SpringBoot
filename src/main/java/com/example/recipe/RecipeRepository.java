// Write your code here
package com.example.recipe;

import java.util.*;

public interface RecipeRepository {
    List<Recipe> getAllRecipes();

    Recipe addRecipe(Recipe recipe);

    Recipe updateRecipe(int recipeId, Recipe recipe);

    Recipe getRecipeById(int recipeId);

    void deleteRecipe(int recipeId);
}