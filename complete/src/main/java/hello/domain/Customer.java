package hello.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Customer {

	public Customer(String name, List<String> ingredientRecipe) {
		this.setName(name);
		this.setIngredientRecipe(ingredientRecipe);
	}

	public Customer() {
	}

	@Id
	private String id;
	private String name;
	private List<String> ingredientRecipe;

	public List<String> getIngredientRecipe() {
		return ingredientRecipe;
	}

	public void setIngredientRecipe(List<String> ingredientRecipe) {
		this.ingredientRecipe = ingredientRecipe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
