package com.lmig.gfc.cookiejarbe.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lmig.gfc.cookiejarbe.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

	List<Recipe> findById(int id);

	List<Recipe> findByNameIgnoringCaseContaining(String name);

	List<Recipe> findByUserId(Long id);

}
