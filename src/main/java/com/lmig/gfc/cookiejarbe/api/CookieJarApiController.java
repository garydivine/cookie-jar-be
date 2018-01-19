
package com.lmig.gfc.cookiejarbe.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lmig.gfc.cookiejarbe.models.Recipe;
import com.lmig.gfc.cookiejarbe.repositories.RecipeRepository;

@RestController
@RequestMapping("/api/cookies")
@CrossOrigin(origins = "*")
public class CookieJarApiController {

	private RecipeRepository recipeRepo;

	public CookieJarApiController(RecipeRepository recipeRepo) {
		this.recipeRepo = recipeRepo;
	}

	@GetMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<RecipeView> findByUserId(@PathVariable Long id) {

		ArrayList<RecipeView> recipeViews = new ArrayList<RecipeView>();

		List<Recipe> recipes = recipeRepo.findByUserId(id);
		for (Recipe recipe : recipes) {
			recipeViews.add(new RecipeView(recipe));
		}
		return recipeViews;
	}

}
