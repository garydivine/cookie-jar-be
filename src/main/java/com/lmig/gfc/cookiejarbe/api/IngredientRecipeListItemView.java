package com.lmig.gfc.cookiejarbe.api;

import com.lmig.gfc.cookiejarbe.models.Ingredient;
import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;

public class IngredientRecipeListItemView {
private IngredientRecipeListItem ingredientRecipeListItem;
	
	public IngredientRecipeListItemView(IngredientRecipeListItem ingredientRecipeListItem) {
		this.ingredientRecipeListItem = ingredientRecipeListItem;
	};
	
	public int getId() {
		return ingredientRecipeListItem.getId();
	}

	public String getQuantity() {
		return ingredientRecipeListItem.getQuantity();
	}

	public String getUnitOfMeasurement() {
		return ingredientRecipeListItem.getUnitOfMeasurement();
	}

	public Ingredient getIngredient() {
		return ingredientRecipeListItem.getIngredient();
	}


}
