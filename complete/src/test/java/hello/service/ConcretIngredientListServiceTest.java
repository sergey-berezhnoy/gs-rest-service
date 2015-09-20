package hello.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hello.dao.IngredientDao;
import hello.dao.IngredientListDao;
import hello.domain.Ingredient;
import hello.domain.IngredientList;

public class ConcretIngredientListServiceTest {

	@Mock
	private IngredientListDao daoList;// TODO
	@Mock
	private IngredientDao dao;

	@InjectMocks
	private ConcretIngredientListService service;// TODO

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);// TODO
	}

	@Test
	public void updateListTest() {

		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(new Ingredient("a", 1, 1, true, 1));
		ingredients.add(new Ingredient("b", 2, 2, false, 2));
		IngredientList ingredientList = new IngredientList();
		ingredientList.setPrice(1);
		ingredientList.setIngredients(ingredients);
		ingredientList.setName("wellknownList");

		List<Ingredient> newingredients = new ArrayList<>();
		ingredients.add(new Ingredient("a", 1, 1, true, 1));
		ingredients.add(new Ingredient("b", 2, 2, false, 2));
		IngredientList newingredientList = new IngredientList();
		newingredientList.setPrice(2);
		newingredientList.setIngredients(newingredients);
		newingredientList.setName("wellknownList");

		when(daoList.getByName("wellknownList")).thenReturn(ingredientList);

		service.createOrUpdate(newingredientList);

		verify(daoList).save(ingredientList);
		assertEquals(2, ingredientList.getPrice());
	}

	@Test
	public void createListTest() {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(new Ingredient("a", 1, 1, true, 1));
		ingredients.add(new Ingredient("b", 2, 2, false, 2));

		when(daoList.getByName("unknownList")).thenReturn(null);
		IngredientList ingredientList = new IngredientList();
		ingredientList.setIngredients(ingredients);
		ingredientList.setName("unknownList");
		service.createOrUpdate(ingredientList);

		verify(daoList).save(ingredientList);
	}

}
