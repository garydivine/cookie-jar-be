package com.lmig.gfc.cookiejarbe.api;

import java.util.ArrayList;
import java.util.List;

import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;
import com.lmig.gfc.cookiejarbe.models.Recipe;

public class RecipeView {

	private Recipe recipe;

	public RecipeView(Recipe recipe) {
		this.recipe = recipe;
	}

	public int getId() {
		return recipe.getId();
	}

	public String getName() {
		return recipe.getName();
	}

	public int getTemp() {
		return recipe.getTemp();
	}

	public String getTime() {
		return recipe.getTime();
	}

	public String getInstructions() {
		return recipe.getInstructions();
	}

	public int getYield() {
		return recipe.getYield();
	}

	public List<IngredientRecipeListItemView> getIngredientRecipeListItem() {
		ArrayList<IngredientRecipeListItemView> views = new ArrayList<IngredientRecipeListItemView>();
		for (IngredientRecipeListItem ingredientRecipeListItem : recipe.getIngredientRecipeListItem()) {
			views.add(new IngredientRecipeListItemView(ingredientRecipeListItem));
		}
		return views;
	}

}
