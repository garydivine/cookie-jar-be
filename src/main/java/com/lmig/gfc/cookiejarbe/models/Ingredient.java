package com.lmig.gfc.cookiejarbe.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "ingredient")
	@JsonIgnore
	private List<IngredientRecipeListItem> ingredientRecipeListItem;
	
	public Ingredient() {
		
	}

	public Ingredient(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IngredientRecipeListItem> getIngredientRecipeListItem() {
		return ingredientRecipeListItem;
	}

	public void setIngredientRecipeListItem(List<IngredientRecipeListItem> ingredientRecipeListItem) {
		this.ingredientRecipeListItem = ingredientRecipeListItem;
	}


}
