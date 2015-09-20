package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.domain.IngredientList;
import hello.service.IngredientListService;

@RestController
public class IngredientListController {

	@Autowired
	private IngredientListService ingredientListService;

	@RequestMapping(value = "/ingredientlist", method = RequestMethod.GET)
	public List<IngredientList> getIngredients(@RequestParam(value = "name") String name) {
		return ingredientListService.getListByName(name);
	}

	@RequestMapping(value = "/ingredientlist", method = RequestMethod.POST)
	public IngredientList addNewIngredient(@RequestBody IngredientList ingredientList) {
		return ingredientListService.createOrUpdate(ingredientList);
	}

	@RequestMapping(value = "/ingredientlist/ingredient", method = RequestMethod.GET)
	public List<IngredientList> getListWithIngredient(@RequestParam(value = "name") String ingredientName) {
		return ingredientListService.getListByIngredientName(ingredientName);
	}

	@RequestMapping(value = "/ingredientlist/price", method = RequestMethod.GET)
	public int getListPrice(@RequestParam(value = "name") String listName) {
		return ingredientListService.getListPriceByName(listName);
	}
}
