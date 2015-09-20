package hello.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hello.dao.IngredientDao;
import hello.domain.Ingredient;

public class ConcretIngredientServiceTest {

	@Mock
	private IngredientDao dao;

	@InjectMocks
	private ConcretIngredientService service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() {
		when(dao.getByName("Beer")).thenReturn(null);

		List<Ingredient> actual = service.getIngredientByName("Beer");

		assertTrue(actual.size() == 0);
	}

	@Test
	public void testCreate() {
		String beer = "Beer";
		when(dao.getByName(beer)).thenReturn(null);
		Ingredient beerIngredient = new Ingredient();
		beerIngredient.setName(beer);
		beerIngredient.setRecipe(true);

		service.createIngredient(beerIngredient);

		verify(dao).save(beerIngredient);
	}

	@Test
	public void testCreateDoesNotCreateWhenExists() {
		Ingredient oldVanillaIngredient = new Ingredient();
		oldVanillaIngredient.setName("vanilla");
		when(dao.getByName("vanilla")).thenReturn(oldVanillaIngredient);
		Ingredient newVanillaIngredient = new Ingredient();
		newVanillaIngredient.setName("vanilla");

		assertEquals(oldVanillaIngredient, service.createIngredient(newVanillaIngredient));
	}

}
