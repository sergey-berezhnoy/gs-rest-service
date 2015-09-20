package hello.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Order {

	public Order(Customer customer, List<Ingredient> ingredients) {
		this.setCustomer(customer);
		this.setIngredients(ingredients);
	}

	public Order() {
	}

	@Id
	private String id;
	@DBRef
	private List<Ingredient> ingredients;
	@DBRef
	private Customer customer;

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
