package com.lmig.gfc.cookiejarbe.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recipe {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private int temp;
	
	private int time;
	
	private String instructions;
	
	private int yield;
	
	@OneToMany(mappedBy = "recipe")
	private List<IngredientRecipeListItem> ingredientRecipeListItem;
	
	
	
	

}
