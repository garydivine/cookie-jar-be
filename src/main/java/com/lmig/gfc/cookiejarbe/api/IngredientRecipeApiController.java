package com.lmig.gfc.cookiejarbe.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;
import com.lmig.gfc.cookiejarbe.models.Recipe;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRecipeRepository;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRepository;
import com.lmig.gfc.cookiejarbe.repositories.RecipeRepository;

@RestController
@RequestMapping("/api/ingredientToRecipe")
@CrossOrigin(origins = "*")
public class IngredientRecipeApiController {

	private IngredientRecipeRepository ingredientRecipeRepo;
	private IngredientRepository ingredientRepo;
	private RecipeRepository recipeRepo;

	public IngredientRecipeApiController(IngredientRecipeRepository ingredientRecipeRepo,
			IngredientRepository ingredientRepo, RecipeRepository recipeRepo) {
		this.ingredientRecipeRepo = ingredientRecipeRepo;
		this.ingredientRepo = ingredientRepo;
		this.recipeRepo = recipeRepo;

	}

	@PostMapping("{recipeId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RecipeView create(@PathVariable Integer recipeId,
			@RequestBody IngredientRecipeListItem ingredientRecipeListItem) {
		Recipe recipe = recipeRepo.findOne(recipeId);
		ingredientRecipeListItem.setRecipe(recipe);
		ingredientRecipeRepo.save(ingredientRecipeListItem);
		Recipe updatedRecipe = recipeRepo.findOne(recipeId);
		return new RecipeView(updatedRecipe);
	}

	@DeleteMapping("{ingredientRecipeListItemId}")
	public IngredientRecipeListItem delete(@PathVariable int ingredientRecipeListItemId) {
		IngredientRecipeListItem ingredientRecipeListItem = ingredientRecipeRepo.findOne(ingredientRecipeListItemId);
		ingredientRecipeRepo.delete(ingredientRecipeListItem);
		return ingredientRecipeListItem;
	}
}
