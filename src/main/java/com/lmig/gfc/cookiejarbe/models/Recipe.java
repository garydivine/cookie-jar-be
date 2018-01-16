package com.lmig.gfc.cookiejarbe.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(generator = "recipe_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "recipe_id_seq", sequenceName = "recipe_id_seq")
	private int id;

	@Column(nullable = false)
	private String name;

	private int temp;

	private String time;

	@Column(length = 1000, nullable = false)
	private String instructions;

	private int yield;

	@OneToMany(mappedBy = "recipe")
	private List<IngredientRecipeListItem> ingredientRecipeListItem;

	@ManyToOne
	private User user;

	public Recipe() {

	}

	public Recipe(String name, String instructions, int temp, int yield, String time) {
		this.name = name;
		this.instructions = instructions;
		this.temp = temp;
		this.yield = yield;
		this.time = time;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getTemp() {
		return temp;
	}

	public String getTime() {
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

	public void setTime(String time) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
