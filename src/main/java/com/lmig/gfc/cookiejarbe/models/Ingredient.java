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

}
