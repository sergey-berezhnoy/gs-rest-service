package hello.service;

import java.util.List;

import hello.domain.Customer;
import hello.domain.Ingredient;

public interface CustomerService {
	public List<Customer> findCustomerByName(String name);

	public Customer getCustomerByName(String name);

	public List<String> getIngredientRecipeByCustomerName(String name);

	public Customer createOrUpdateCustomer(Customer customer);

	public Ingredient getIngredientIfCustomerHasRecipe(String ingredientName, String customerName);

}
