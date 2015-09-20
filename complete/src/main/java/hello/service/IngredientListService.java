package hello.service;

import java.util.List;

import hello.domain.IngredientList;

public interface IngredientListService {
	public List<IngredientList> getListByName(String name);

	public List<IngredientList> getListByIngredientName(String ingredientName);

	public List<String> getIngredientsNames(IngredientList ingredientList);

	public IngredientList createOrUpdate(IngredientList ingredientList);

	public int getListPriceByName(String name);
}
