package com.lmig.gfc.cookiejarbe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredient {

	@Id
	@GeneratedValue(generator = "ingredient_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "ingredient_id_seq", sequenceName = "ingredient_id_seq")
	private int id;

	private String name;

	@OneToOne(mappedBy = "ingredient")
	@JsonIgnore
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
