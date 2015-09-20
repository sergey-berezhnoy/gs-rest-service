package hello.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.dao.IngredientDao;
import hello.dao.IngredientListDao;
import hello.domain.Ingredient;
import hello.domain.IngredientList;

@Component
public class ConcretIngredientListService implements IngredientListService {
	@Autowired
	private IngredientListDao ingredientListDao;

	@Autowired
	private IngredientDao ingredientDao;

	@Override
	public List<IngredientList> getListByName(String name) {
		return ingredientListDao.findByName(name);
	}

	@Override
	public IngredientList createOrUpdate(IngredientList ingredientList) {
		IngredientList existingIngredientList = ingredientListDao.getByName(ingredientList.getName());
		List<Ingredient> internalIngredientList = new ArrayList<>();
		for (Ingredient ingredient : ingredientList.getIngredients()) {
			Ingredient existingIngredient = ingredientDao.getByName(ingredient.getName());
			if (existingIngredient != null) {
				internalIngredientList.add(existingIngredient);
			} else {
				internalIngredientList.add(ingredientDao.save(ingredient));
			}
		}
		if (existingIngredientList != null) {
			existingIngredientList.setIngredients(internalIngredientList);
			existingIngredientList.setPrice(ingredientList.getPrice());
			return ingredientListDao.save(existingIngredientList);
		} else {
			ingredientList.setIngredients(internalIngredientList);
			return ingredientListDao.save(ingredientList);
		}
	}

	@Override
	public List<IngredientList> getListByIngredientName(String ingredientName) {
		List<IngredientList> requestedList = new ArrayList<>();
		for (IngredientList ingredientList : ingredientListDao.findAll()) {
			List<String> namesList = getIngredientsNames(ingredientList);
			if (namesList.contains(ingredientName)) {
				requestedList.add(ingredientList);
			}
		}
		return requestedList;
	}

	@Override
	public List<String> getIngredientsNames(IngredientList ingredientList) {
		List<String> namesList = new ArrayList<>();
		for (Ingredient ingredient : ingredientList.getIngredients()) {
			namesList.add(ingredient.getName());
		}
		return namesList;
	}

	@Override
	public int getListPriceByName(String name) {
		IngredientList ingredientList = ingredientListDao.getByName(name);
		return ingredientList.getPrice();
	}
}
