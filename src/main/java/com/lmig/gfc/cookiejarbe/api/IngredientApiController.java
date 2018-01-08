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

import com.lmig.gfc.cookiejarbe.models.Ingredient;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRepository;

@RestController
@RequestMapping("/api/ingredients")
@CrossOrigin(origins = "*")
public class IngredientApiController {

	private IngredientRepository ingredientRepo;

	public IngredientApiController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Ingredient> getAll() {
		List<Ingredient> ingredients = ingredientRepo.findAll();
		return ingredients;
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Ingredient getOne(@PathVariable int id) {
		Ingredient ingredient = ingredientRepo.findOne(id);
		return ingredient;
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return ingredientRepo.save(ingredient);
	}

	@PutMapping("{id}")
	public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable int id) {
		ingredient.setId(id);
		return ingredientRepo.save(ingredient);
	}

	@DeleteMapping("{id}")
	public Ingredient delete(@PathVariable int id) {
		Ingredient ingredient = ingredientRepo.findOne(id);
		return ingredient;
	}
}
