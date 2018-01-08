package com.lmig.gfc.cookiejarbe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@OneToOne(mappedBy = "ingredient")
	private IngredientRecipeListItem ingredientRecipeListItem;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public IngredientRecipeListItem getIngredientRecipeListItem() {
		return ingredientRecipeListItem;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIngredientRecipeListItem(IngredientRecipeListItem ingredientRecipeListItem) {
		this.ingredientRecipeListItem = ingredientRecipeListItem;
	}

}
