package com.lmig.gfc.cookiejarbe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class IngredientRecipeListItem {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int quantity;
	
	private String unitOfMeasurement;
	
	@ManyToOne()
	//@JsonIgnore
	private Recipe recipe;
	
	@OneToOne
	private Ingredient ingredient;
	

}
