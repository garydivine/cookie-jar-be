package com.lmig.gfc.cookiejarbe.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.cookiejarbe.models.Ingredient;
import com.lmig.gfc.cookiejarbe.models.Recipe;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRepository;
import com.lmig.gfc.cookiejarbe.repositories.RecipeRepository;

@Configuration
public class SeedData {

	public SeedData(IngredientRepository ingredientRepo, RecipeRepository recipeRepo) {
		ingredientRepo.save(new Ingredient("flour"));
		ingredientRepo.save(new Ingredient("sugar"));
		ingredientRepo.save(new Ingredient("brown sugar"));
		ingredientRepo.save(new Ingredient("soda"));
		ingredientRepo.save(new Ingredient("salt"));
		recipeRepo.save(new Recipe("peanut butter cloud", "baking", 350, 24, 12));
		recipeRepo.save(new Recipe("chocolate chip", "how to cook", 350, 30, 10));
		recipeRepo.save(new Recipe("date bar", "mixing", 350, 18, 45));
	}
}
