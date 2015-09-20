package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.domain.Ingredient;
import hello.service.IngredientService;

@RestController
public class IngredientController {

	@Autowired
	private IngredientService ingredientService;

	@RequestMapping(value = "/ingredient", method = RequestMethod.GET)
	public List<Ingredient> getIngredients(@RequestParam(value = "name") String name) {
		return ingredientService.getIngredientByName(name);
	}

	@RequestMapping(value = "/ingredient/lowerprice", method = RequestMethod.GET)
	public List<Ingredient> getIngredientsByLowerPrice(@RequestParam(value = "price", defaultValue = "100") int price) {
		return ingredientService.getIngredientByPriceLessThan(price);
	}

	@RequestMapping(value = "/ingredient/higherprice", method = RequestMethod.GET)
	public List<Ingredient> getIngredientsByHigherPrice(@RequestParam(value = "price", defaultValue = "1") int price) {
		return ingredientService.getIngredientByPriceGreaterThan(price);
	}

	@RequestMapping(value = "/ingredient/recipe", method = RequestMethod.GET)
	public List<Ingredient> getIngredients(@RequestParam(value = "recipe", defaultValue = "true") boolean recipe) {
		return ingredientService.getIngredientByRecipeValue(recipe);
	}

	@RequestMapping(value = "/ingredient", method = RequestMethod.POST)
	public Ingredient addNewIngredient(@RequestBody Ingredient ingredient) {
		return ingredientService.createIngredient(ingredient);
	}

}
