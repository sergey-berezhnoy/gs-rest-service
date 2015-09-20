package hello.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.dao.CustomerDao;
import hello.dao.IngredientDao;
import hello.dao.OrderDao;
import hello.domain.Customer;
import hello.domain.Ingredient;
import hello.domain.Order;
import hello.domain.OrderRequest;

@Component
public class ConcretOrderService implements OrderService {
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private IngredientDao ingredientDao;

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Order createAnOrder(OrderRequest orderRequest) {
		Customer customer = customerDao.getByName(orderRequest.getCustomerName());
		if (customer != null) {
			List<Ingredient> ingredientList = getIngredientList(orderRequest.getIngredientNames());
			if (ingredientList.size() != 0) {
				Order order = new Order(customer, ingredientList);
				return orderDao.save(order);
			}
		}
		return null;
	}

	public List<Ingredient> getIngredientList(List<String> ingredients) {
		List<Ingredient> ingredientList = new ArrayList<>();
		for (String ingredientName : ingredients) {
			Ingredient ingredient = ingredientDao.getByName(ingredientName);
			if (ingredient != null) {
				ingredientList.add(ingredient);
			}
		}
		return ingredientList;
	}

}
