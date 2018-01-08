package com.lmig.gfc.cookiejarbe.api;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.cookiejarbe.models.Recipe;
import com.lmig.gfc.cookiejarbe.repositories.RecipeRepository;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "*")
public class RecipeApiController {

	private RecipeRepository recipeRepo;

	public RecipeApiController(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recipe> getAll() {
		List<Recipe> recipes = recipeRepo.findAll();
		return recipes;
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Recipe getOne(@PathVariable int id) {
		Recipe recipe = recipeRepo.findOne(id);
		return recipe;
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
		return recipe;
	}
}
