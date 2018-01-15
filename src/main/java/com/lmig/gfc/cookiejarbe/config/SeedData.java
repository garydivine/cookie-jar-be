package com.lmig.gfc.cookiejarbe.config;

import org.springframework.context.annotation.Configuration;

import com.lmig.gfc.cookiejarbe.models.Ingredient;
import com.lmig.gfc.cookiejarbe.models.IngredientRecipeListItem;
import com.lmig.gfc.cookiejarbe.models.Recipe;
import com.lmig.gfc.cookiejarbe.models.User;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRecipeRepository;
import com.lmig.gfc.cookiejarbe.repositories.IngredientRepository;
import com.lmig.gfc.cookiejarbe.repositories.RecipeRepository;
import com.lmig.gfc.cookiejarbe.repositories.UserRepository;

@Configuration
public class SeedData {

	public SeedData(IngredientRepository ingredientRepo, RecipeRepository recipeRepo,
			IngredientRecipeRepository ingredientRecipeRepo, UserRepository userRepo) {

		User jon = new User("Jon");
		userRepo.save(jon);

		User marci = new User("Marci");
		userRepo.save(marci);

		User karen = new User("Karen");
		userRepo.save(karen);

		User gary = new User("Gary");
		userRepo.save(gary);

		User david = new User("David");
		userRepo.save(david);

		Ingredient flour = new Ingredient("flour");
		ingredientRepo.save(flour);

		Ingredient raisins = new Ingredient("raisins");
		ingredientRepo.save(raisins);

		Ingredient whiteSugar = new Ingredient("sugar(white)");
		ingredientRepo.save(whiteSugar);

		Ingredient packedLightBrownSugar = new Ingredient("brown sugar(light)");
		ingredientRepo.save(packedLightBrownSugar);

		Ingredient packedDarkBrownSugar = new Ingredient("brown sugar(dark)");
		ingredientRepo.save(packedDarkBrownSugar);

		Ingredient bakingSoda = new Ingredient("baking soda");
		ingredientRepo.save(bakingSoda);

		Ingredient salt = new Ingredient("salt");
		ingredientRepo.save(salt);

		Ingredient creamyPeanutButter = new Ingredient("peanut butter(creamy)");
		ingredientRepo.save(creamyPeanutButter);

		Ingredient dates = new Ingredient("dates");
		ingredientRepo.save(dates);

		Ingredient milk = new Ingredient("milk");
		ingredientRepo.save(milk);

		Ingredient vanilla = new Ingredient("vanilla");
		ingredientRepo.save(vanilla);

		Ingredient regularRolledOats = new Ingredient("oats(regular)");
		ingredientRepo.save(regularRolledOats);

		Ingredient quickCookingOats = new Ingredient("oats(quick cooking)");
		ingredientRepo.save(quickCookingOats);

		Ingredient semisweetChocolateChips = new Ingredient("chocolate chips(semi-sweet)");
		ingredientRepo.save(semisweetChocolateChips);

		Ingredient butter = new Ingredient("butter");
		ingredientRepo.save(butter);

		Ingredient eggs = new Ingredient("eggs");
		ingredientRepo.save(eggs);

		Ingredient shreddedCoconut = new Ingredient("coconut(shredded)");
		ingredientRepo.save(shreddedCoconut);

		Ingredient cocoa = new Ingredient("cocoa");
		ingredientRepo.save(cocoa);

		Ingredient riceCrispies = new Ingredient("rice crispies");
		ingredientRepo.save(riceCrispies);

		Ingredient lightKaroSyrup = new Ingredient("karo syrup(light)");
		ingredientRepo.save(lightKaroSyrup);

		Ingredient molasses = new Ingredient("molasses");
		ingredientRepo.save(molasses);

		Ingredient shortening = new Ingredient("shortening");
		ingredientRepo.save(shortening);

		Ingredient groundGinger = new Ingredient("ginger(ground)");
		ingredientRepo.save(groundGinger);

		Ingredient groundCinnamon = new Ingredient("cinnamon(ground)");
		ingredientRepo.save(groundCinnamon);

		Ingredient powderedSugar = new Ingredient("sugar(powdered)");
		ingredientRepo.save(powderedSugar);

		Ingredient coldWater = new Ingredient("cold water");
		ingredientRepo.save(coldWater);

		Recipe oatmealRaisinCookie = new Recipe("Oatmeal Raisin",
				"Pre-heat oven to 375 degrees F. In large bowl, cream together butter, white sugar, and brown sugar until smooth. Beat in the eggs and vanilla until fluffy. Stir together flour, baking soda, cinnamon, and salt. Gradually beat into butter mixture. Stir in oats and raisins. Drop by teaspoonfuls onto ungreased cookie sheet. Bake 8 to 10 minutes in the preheated oven, or until golden brown. Cool slightly, remove from sheet to wire rack. Cool completely.",
				375, 24, "8 minutes");

		recipeRepo.save(oatmealRaisinCookie);
		oatmealRaisinCookie.setUser(david);
		recipeRepo.save(oatmealRaisinCookie);

		ingredientRecipeRepo.save(new IngredientRecipeListItem("1 1/4", "cups", flour, oatmealRaisinCookie));
		ingredientRecipeRepo
				.save(new IngredientRecipeListItem("2 3/4", "cups", regularRolledOats, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", raisins, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("2", "", eggs, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", vanilla, oatmealRaisinCookie));
		ingredientRecipeRepo
				.save(new IngredientRecipeListItem("3/4", "cup", packedLightBrownSugar, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", bakingSoda, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("3/4", "teaspoon", groundCinnamon, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1/2", "teaspoon", salt, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("3/4", "cup", whiteSugar, oatmealRaisinCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("3/4", "cup", butter, oatmealRaisinCookie));

		Recipe chocolateChipCookie = new Recipe("Chocolate Chip",
				"Pre-heat oven to 375 degrees F. In large bowl, cream together butter and white sugar, until smooth. Beat in the eggs and vanilla until fluffy. Stir together flour, baking soda and salt. Gradually beat into butter mixture. Stir in chocolate chips. Drop by teaspoonfuls onto ungreased cookie sheet. Bake 8 to 10 minutes in the preheated oven, or until golden brown. Cool slightly, remove from sheet to wire rack. Cool completely.",
				375, 24, "8 to 10 minutes");

		recipeRepo.save(chocolateChipCookie);
		chocolateChipCookie.setUser(karen);
		recipeRepo.save(chocolateChipCookie);

		ingredientRecipeRepo.save(new IngredientRecipeListItem("2 1/4", "cups", flour, chocolateChipCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("2", "", eggs, chocolateChipCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", vanilla, chocolateChipCookie));
		ingredientRecipeRepo
				.save(new IngredientRecipeListItem("3/4", "cup", packedLightBrownSugar, chocolateChipCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("3/4", "cup", whiteSugar, chocolateChipCookie));
		ingredientRecipeRepo
				.save(new IngredientRecipeListItem("2", "cups", semisweetChocolateChips, chocolateChipCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", bakingSoda, chocolateChipCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", butter, chocolateChipCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", salt, chocolateChipCookie));

		Recipe peanutButterCloudCookie = new Recipe("Peanut Butter Cloud",
				"Pre-heat oven to 350 degrees F. In large bowl, cream together shortening, peanut butter, powdered sugar and white sugar until smooth. Beat in the eggs and vanilla until fluffy. sift flour, baking soda and salt into creamed mixture. Beat well. (Batter will be stiff). Let dough sit in refrigerator covered for a couple of hours or overnight. Roll into balls and drop on cookie sheet. Flatten with flour-dipped fork. Bake 12 to 15 minutes, or until golden brown. Cool slightly, remove from sheet to wire rack. Cool completely.",
				350, 60, "12 to 15 minutes");

		recipeRepo.save(peanutButterCloudCookie);
		peanutButterCloudCookie.setUser(marci);
		recipeRepo.save(peanutButterCloudCookie);

		ingredientRecipeRepo.save(new IngredientRecipeListItem("2", "cups", flour, peanutButterCloudCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("2", "", eggs, peanutButterCloudCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", vanilla, peanutButterCloudCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", powderedSugar, peanutButterCloudCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", whiteSugar, peanutButterCloudCookie));
		ingredientRecipeRepo
				.save(new IngredientRecipeListItem("1", "cup", creamyPeanutButter, peanutButterCloudCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("2", "teaspoons", bakingSoda, peanutButterCloudCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", shortening, peanutButterCloudCookie));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", salt, peanutButterCloudCookie));

		Recipe dateBar = new Recipe("Date Bar",
				"Pre-heat oven to 350 degrees F. In large bowl, cream together shortening, peanut butter, powdered sugar and white sugar until smooth. Beat in the eggs and vanilla until fluffy. sift flour, baking soda and salt into creamed mixture. Beat well. (Batter will be stiff). Let dough sit in refrigerator covered for a couple of hours or overnight. Roll into balls and drop on cookie sheet. Flatten with flour-dipped fork. Bake 12 to 15 minutes, or until golden brown. Cool slightly,  Cool completely.",
				350, 24, "40 to 45 minutes");

		recipeRepo.save(dateBar);
		dateBar.setUser(jon);
		recipeRepo.save(dateBar);

		ingredientRecipeRepo.save(new IngredientRecipeListItem("1 1/2", "cups", flour, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1 to 1/2 ", "pounds", dates, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("3/4", "cup", whiteSugar, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1 3/4", "cups", regularRolledOats, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", bakingSoda, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", shortening, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", coldWater, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", salt, dateBar));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1 1/2", "cups ", packedLightBrownSugar, dateBar));

		Recipe chocolateCoconutHaystack = new Recipe("Chocolate Coconut Haystack",
				"In a large pot mix together the sugar, cocoa and milk. Cook on medium/low heat for about 5 minutes or until the sugar dissolves. Turn the heat up to medium and add butter and allow that to melt and come to a low boil.Stir in oats, salt and vanilla – mix well. Finally add in coconut and stir until everything is coated. Drop by teaspoon onto a parchment paper lined cookie sheet and let set.",
				0, 24, "no bake");

		recipeRepo.save(chocolateCoconutHaystack);
		chocolateCoconutHaystack.setUser(gary);
		recipeRepo.save(chocolateCoconutHaystack);

		ingredientRecipeRepo.save(new IngredientRecipeListItem("1 1/4", "cups", whiteSugar, chocolateCoconutHaystack));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("5 ", "tablespoons", cocoa, chocolateCoconutHaystack));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1/2", "cup", milk, chocolateCoconutHaystack));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1/2", "cup", butter, chocolateCoconutHaystack));
		ingredientRecipeRepo
				.save(new IngredientRecipeListItem("3", "cups", quickCookingOats, chocolateCoconutHaystack));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("pinch", "", salt, chocolateCoconutHaystack));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup", coldWater, chocolateCoconutHaystack));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "teaspoon", vanilla, chocolateCoconutHaystack));
		ingredientRecipeRepo.save(new IngredientRecipeListItem("1", "cup ", shreddedCoconut, chocolateCoconutHaystack));

	}

}
