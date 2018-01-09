package com.lmig.gfc.cookiejarbe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;
import com.lmig.gfc.cookiejarbe.models.Recipe;

@Repository
public interface IngredientRecipeRepository extends JpaRepository<IngredientRecipeListItem, Integer> {
	
	List<IngredientRecipeListItem> findByRecipe(Recipe recipe);

}
