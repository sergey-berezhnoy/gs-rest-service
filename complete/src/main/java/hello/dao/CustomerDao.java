package hello.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.domain.Customer;

public interface CustomerDao extends MongoRepository<Customer, String> {
	public Customer getByName(String name);

	public List<Customer> findByName(String name);
}
