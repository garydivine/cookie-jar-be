package com.lmig.gfc.cookiejarbe.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.cookiejarbe.models.Ingredient;
import com.lmig.gfc.cookiejarbe.models.Recipe;
import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRepository;
import com.lmig.gfc.cookiejarbe.repositories.RecipeRepository;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRecipeRepository;

@Configuration
public class SeedData {

	
	
	public SeedData(IngredientRepository ingredientRepo, RecipeRepository recipeRepo, IngredientRecipeRepository ingredientRecipeRepo) {
	
		
		
		Ingredient flour = new Ingredient("flour");
		ingredientRepo.save(flour);
		
		Ingredient sugar = new Ingredient("sugar");
		ingredientRepo.save(sugar);
		
		Ingredient packedBrownSugar = new Ingredient("packed brown sugar");
		ingredientRepo.save(packedBrownSugar);
		
		Ingredient bakingSoda = new Ingredient("baking soda");
		ingredientRepo.save(bakingSoda);
		
		Ingredient salt = new Ingredient("salt");
		ingredientRepo.save(salt);
		
		Ingredient peanutButter = new Ingredient("peanut butter");
		ingredientRepo.save(peanutButter);
		
		Ingredient dates = new Ingredient("dates");
		ingredientRepo.save(dates);
		
		Ingredient milk = new Ingredient("milk");
		ingredientRepo.save(milk);
		
		Ingredient vanilla = new Ingredient("vanilla");
		ingredientRepo.save(vanilla);
		
		Ingredient regularOatmeal = new Ingredient("regular oatmeal");
		ingredientRepo.save(regularOatmeal);
		
		Ingredient semisweetChocolateChips = new Ingredient("semi-sweet chocolate chips");
		ingredientRepo.save(semisweetChocolateChips);
		
		Ingredient butter = new Ingredient("butter");
		ingredientRepo.save(butter);
		
		Ingredient eggs = new Ingredient("eggs");
		ingredientRepo.save(eggs);
		
		Ingredient coconutFlakes = new Ingredient("coconut flakes");
		ingredientRepo.save(coconutFlakes);
		
		Ingredient cocoa = new Ingredient("cocoa");
		ingredientRepo.save(cocoa);
		
		Ingredient riceCrispies = new Ingredient("rice crispies");
		ingredientRepo.save(riceCrispies);
		
		Ingredient lightKaroSyrup = new Ingredient("light karo syrup ");
		ingredientRepo.save(lightKaroSyrup);
		
		Ingredient molasses = new Ingredient("molasses");
		ingredientRepo.save(molasses);
		
		Ingredient groundGinger = new Ingredient("ground ginger");
		ingredientRepo.save(groundGinger);
		
		Ingredient groundCinnamon = new Ingredient("ground cinnamon");
		ingredientRepo.save(groundCinnamon);
		
		
		
		
		Recipe oatmealRaisinCookie = new Recipe("Oatmeal Raisin", "Preheat oven to 375 degrees F.", 375, 24, 8);
		recipeRepo.save(oatmealRaisinCookie);
		//needs to be 1 1/4 cup
		ingredientRecipeRepo.save(new IngredientRecipeListItem(1, "cups", flour, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem(2, "", eggs, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem(1, "teaspoon", vanilla, oatmealRaisinCookie));
		//should be 3/4 cup
		ingredientRecipeRepo.save(new IngredientRecipeListItem(1, "cup", packedBrownSugar, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem(1, "teaspoon", bakingSoda, oatmealRaisinCookie));
		//should be 3/4 teaspoon
		ingredientRecipeRepo.save(new IngredientRecipeListItem(1, "teaspoon", groundCinnamon, oatmealRaisinCookie));
		//sb 1/2 tspn
		ingredientRecipeRepo.save(new IngredientRecipeListItem(1, "teaspoon", salt, oatmealRaisinCookie));
		
		
//		recipeRepo.save(new Recipe("Peanut Butter Cloud", "In a large bowl, cream butter together with sugar.  Add the flour, eggs, soda, salt, and peanut butter. cover mixture and chill overnight in refrigerator. Roll into 1 inch balls and drop on ungreased cookie sheet. Pat fork in flour and use to press cookie dough into a round. Bake at 350 for 12 minutes.", 350, 24, 12));
//		recipeRepo.save(new Recipe("Chocolate Chip", "In electric mixing bowl, cream butter and sugars together until smooth. Add eggs, flour, vanilla, soda and salt. Mix until creamy. Drop by spoonful on ungreased cookie sheet. Bake at 350 for 10 to 12 minutes. Remove from sheet and let cool. For soft cookies, add a piece of bread to the storage container.", 350, 30, 10));
//		recipeRepo.save(new Recipe("Date Bar", "Mix flour, regular oats, packed brown sugar, soda, salt and shortning together until crumbly. Pat half of the mixture in the bottom of a 9X13 pan. In a medium sauce pan, cut up 1 to 1 1/2 pounds of dates. Add 1/2 cup granulated sugar. Add 1 to 1 1/2 cups cold water. This amount may vary, depending on how moistness of dates. Cook on medium low heat until mixture becomes mushy. Spread evenly over oatmeal mixture. Cover with remaining oatmeal mixture and pat firmly. Bake at 350 for 40 to 45 minutes  ", 350, 18, 45));
//		recipeRepo.save(new Recipe("Rice Crispy Treats", "In large  bowl, stir karo syrup, rice crispies and peanut butter together until well-blended. Press mixture firmly into an ungreased 9X13 pan. In a medium saucepan, mix semi-sweet and butterscotch chips togeter. Heat on low, stiring frequently until chips are melted and well blended. Spread evenly over mixture in pan. Let cool. Cut into squares.", 0, 20, 0));
//		
//		recipeRepo.save(new Recipe("Chocolate Coconut Haystack", "In a large pot mix together the sugar, cocoa and milk. Cook on medium/low heat for about 5 minutes or until the sugar dissolves. Turn the heat up to medium and add butter and allow that to melt and come to a low boil.Stir in oats, salt and vanilla – mix well. Finally add in coconut and stir until everything is coated. Drop by teaspoon onto a parchment paper lined cookie sheet and let set.", 0, 24,0));
//		recipeRepo.save(new Recipe("Gingersnap","In a large bowl, cream together the butter, brown sugar, egg, and molasses until light and fluffy.  Add flour, baking soda, cinnamon, ginger, cloves, and salt; stir or beat until well blended.  Cover the dough and refrigerate at least 1 hour or overnight. Preheat oven to 375 degrees F. Lightly grease or spray with non-stick cooking spray your cookie sheets. Place some granulated sugar in a bowl large enough to roll the cookie dough balls. Using your hands, shape dough into 1-inch balls.  Then roll the balls of dough into the granulated sugar, coating them thoroughly. Place balls, 3 inches apart, onto prepared cookie sheets. Bake 10 to 12 minutes or until light brown (cookies will puff slightly and then collapse slightly, and tops will be covered with little cracks). Remove from oven and cool on wire racks.", 375, 24,11));
		
	}
	
}
