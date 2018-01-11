package com.lmig.gfc.cookiejarbe.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRecipeRepository;

@RestController
@RequestMapping("/api/ingredientRecipeListItem")
@CrossOrigin(origins = "*")
public class IngredientRecipeListItemWithoutRecipeApiController {
	
	private IngredientRecipeRepository ingredientRecipeRepo;
	
	public IngredientRecipeListItemWithoutRecipeApiController(IngredientRecipeRepository ingredientRecipeRepo) {
		this.ingredientRecipeRepo = ingredientRecipeRepo;
	}

	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public IngredientRecipeListItem create(@RequestBody IngredientRecipeListItem ingredientRecipeListItem) {
		ingredientRecipeRepo.save(ingredientRecipeListItem);
		return ingredientRecipeListItem;
	}
}
