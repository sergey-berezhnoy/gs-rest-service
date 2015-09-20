package hello.domain;

import java.util.List;

public class OrderRequest {
	public OrderRequest(String customerName, List<String> ingredientNames) {
		this.setCustomerName(customerName);
		this.setIngredientNames(ingredientNames);
	}

	public OrderRequest() {
	}

	private List<String> ingredientNames;
	private String customerName;

	public List<String> getIngredientNames() {
		return ingredientNames;
	}

	public void setIngredientNames(List<String> ingredientNames) {
		this.ingredientNames = ingredientNames;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
