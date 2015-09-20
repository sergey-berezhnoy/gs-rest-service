package hello.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.dao.CustomerDao;
import hello.dao.IngredientDao;
import hello.domain.Customer;
import hello.domain.Ingredient;

@Component
public class ConcretCustomerService implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private IngredientDao ingredientDao;

	@Override
	public List<Customer> findCustomerByName(String name) {
		return customerDao.findByName(name);
	}

	@Override
	public Customer getCustomerByName(String name) {
		return customerDao.getByName(name);
	}

	@Override
	public List<String> getIngredientRecipeByCustomerName(String name) {
		Customer customer = customerDao.getByName(name);
		List<String> ingredientRecipeList = customer.getIngredientRecipe();
		return ingredientRecipeList;
	}

	@Override
	public Customer createOrUpdateCustomer(Customer customer) {
		String customerName = customer.getName();
		Customer existingCustomer = customerDao.getByName(customerName);
		if (existingCustomer != null) {
			existingCustomer.setIngredientRecipe(customer.getIngredientRecipe());
			return customerDao.save(existingCustomer);
		}
		return customerDao.save(customer);
	}

	@Override
	public Ingredient getIngredientIfCustomerHasRecipe(String ingredientName, String customerName) {
		Ingredient ingredient = ingredientDao.getByName(ingredientName);
		Customer customer = customerDao.getByName(customerName);
		List<String> customersIngredients = customer.getIngredientRecipe();
		if (ingredient.isRecipe() && customersIngredients.contains(ingredientName)) {
			return ingredient;
		} else if (ingredient.isRecipe()) {
			return null;// TODO add an exception
		}
		return ingredient;
	}

}
