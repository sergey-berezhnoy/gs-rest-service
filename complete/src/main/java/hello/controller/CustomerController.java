package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.domain.Customer;
import hello.domain.Ingredient;
import hello.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public List<Customer> getCustomers(@RequestParam(value = "name") String name) {
		return customerService.findCustomerByName(name);
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer addNewIngredient(@RequestBody Customer customer) {
		return customerService.createOrUpdateCustomer(customer);
	}

	@RequestMapping(value = "/customer/ingredient", method = RequestMethod.GET)
	public Ingredient getIngredientIfCustomerHasRecipe(@RequestParam(value = "name") String name,
			@RequestParam(value = "customerName") String customerName) {
		return customerService.getIngredientIfCustomerHasRecipe(name, customerName);
	}

}
