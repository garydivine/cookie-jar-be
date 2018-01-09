package com.lmig.gfc.cookiejarbe.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(generator = "recipe_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "recipe_id_seq", sequenceName = "recipe_id_seq")
	private int id;

	private String name;

	private int temp;

	private int time;

	private String instructions;

	private int yield;

	@OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
	private List<IngredientRecipeListItem> ingredientRecipeListItem;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTemp() {
		return temp;
	}

	public int getTime() {
		return time;
	}

	public String getInstructions() {
		return instructions;
	}

	public int getYield() {
		return yield;
	}

	public List<IngredientRecipeListItem> getIngredientRecipeListItem() {
		return ingredientRecipeListItem;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public void setYield(int yield) {
		this.yield = yield;
	}

	public void setIngredientRecipeListItem(List<IngredientRecipeListItem> ingredientRecipeListItem) {
		this.ingredientRecipeListItem = ingredientRecipeListItem;
	}

}
