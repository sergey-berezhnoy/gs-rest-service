package hello.domain;

import org.springframework.data.annotation.Id;

public class Ingredient {
	public Ingredient(String name, int quantity, int weight, boolean recipe, int price) {
		this.setName(name);
		this.setQuantity(quantity);
		this.setWeight(weight);
		this.setPrice(price);
		this.setRecipe(recipe);
	}

	public Ingredient() {
	}

	@Id
	private String id;
	private String name;
	private int quantity;
	private int weight;
	private boolean recipe;
	private int price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isRecipe() {
		return recipe;
	}

	public void setRecipe(boolean recipe) {
		this.recipe = recipe;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
