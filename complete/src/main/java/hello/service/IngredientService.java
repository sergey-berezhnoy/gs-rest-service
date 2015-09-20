package hello.service;

import java.util.List;

import hello.domain.Ingredient;

public interface IngredientService {
	public List<Ingredient> getIngredientByName(String name);

	public List<Ingredient> getIngredientByRecipeValue(boolean recipe);

	public List<Ingredient> getIngredientByPriceLessThan(int price);

	public List<Ingredient> getIngredientByPriceGreaterThan(int price);

	public Ingredient createIngredient(Ingredient ingredient);
}
