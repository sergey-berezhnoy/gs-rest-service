package hello.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hello.dao.CustomerDao;
import hello.dao.IngredientDao;
import hello.domain.Customer;
import hello.domain.Ingredient;

public class ConcretCustomerServiceTest {

	@Mock
	private CustomerDao customerDao;
	@Mock
	private IngredientDao ingredientDao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getIngredientIfCustomerHasRecipe() {
		Ingredient ingredient1 = new Ingredient("a", 1, 1, true, 1);
		Ingredient ingredient2 = new Ingredient("b", 2, 2, false, 2);
		List<String> ingredientList = new ArrayList<>();
		ingredientList.add("a");
		ingredientList.add("b");
		Customer customer1 = new Customer("customer1", ingredientList);

	}
}
