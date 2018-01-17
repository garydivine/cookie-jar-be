package com.lmig.gfc.cookiejarbe.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;
import com.lmig.gfc.cookiejarbe.models.Recipe;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRecipeRepository;
import com.lmig.gfc.cookiejarbe.repositories.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "*")
public class RecipeApiController {

	private RecipeRepository recipeRepo;
	private IngredientRecipeRepository ingredientRecipeRepo;

	public RecipeApiController(RecipeRepository recipeRepo, IngredientRecipeRepository ingredientRecipeRepo) {
		this.recipeRepo = recipeRepo;
		this.ingredientRecipeRepo = ingredientRecipeRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<RecipeView> getAll(@RequestParam(value = "name", required = false) String name) {

		ArrayList<RecipeView> recipeViews = new ArrayList<RecipeView>();

		if (name != null) {
			List<Recipe> recipesWithName = recipeRepo.findByNameIgnoringCaseContaining(name);
			for (Recipe recipe : recipesWithName) {
				recipeViews.add(new RecipeView(recipe));
			}
		} else if (name == null) {
			List<Recipe> recipes = recipeRepo.findAll();
			for (Recipe recipe : recipes) {
				recipeViews.add(new RecipeView(recipe));
			}
		}
		return recipeViews;
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public RecipeView getOne(@PathVariable int id) {
		Recipe recipe = recipeRepo.findOne(id);
		if (recipe == null) {
			return null;
		}

		return new RecipeView(recipe);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Recipe create(@RequestBody Recipe recipe) {
		return recipeRepo.save(recipe);
	}

	@PutMapping("{id}")
	public Recipe update(@RequestBody Recipe recipe, @PathVariable int id) {
		recipe.setId(id);
		return recipeRepo.save(recipe);
	}

	@DeleteMapping("{id}")
	public Recipe delete(@PathVariable int id) {
		Recipe recipe = recipeRepo.findOne(id);

		List<IngredientRecipeListItem> ingredientRecipeListItems = ingredientRecipeRepo.findByRecipe(recipe);

		ingredientRecipeRepo.delete(ingredientRecipeListItems);

		recipeRepo.delete(recipeRepo.findById(id));
		return recipe;
	}
}
