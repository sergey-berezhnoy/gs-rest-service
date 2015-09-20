package hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.dao.IngredientDao;
import hello.domain.Ingredient;

@Component
public class ConcretIngredientService implements IngredientService {

	@Autowired
	private IngredientDao ingredientDao;

	@Override
	public List<Ingredient> getIngredientByName(String name) {
		return ingredientDao.findByName(name);
	}

	@Override
	public List<Ingredient> getIngredientByRecipeValue(boolean recipe) {
		if (recipe) {
			return ingredientDao.findByRecipeIsTrue();
		}
		return ingredientDao.findByRecipeIsFalse();
	}

	@Override
	public List<Ingredient> getIngredientByPriceLessThan(int price) {
		return ingredientDao.findByPriceLessThan(price);
	}

	@Override
	public List<Ingredient> getIngredientByPriceGreaterThan(int price) {
		return ingredientDao.findByPriceGreaterThan(price);
	}

	@Override
	public Ingredient createIngredient(Ingredient ingredient) {
		Ingredient existingIngredient = ingredientDao.getByName(ingredient.getName());
		if (existingIngredient == null) {
			return ingredientDao.save(ingredient);
		}
		return existingIngredient;
	}

}
