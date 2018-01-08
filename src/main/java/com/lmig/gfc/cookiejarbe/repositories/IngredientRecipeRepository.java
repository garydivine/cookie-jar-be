package com.lmig.gfc.cookiejarbe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;

@Repository
public interface IngredientRecipeRepository extends JpaRepository<IngredientRecipeListItem, Integer> {

}
