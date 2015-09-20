package hello.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import hello.domain.Order;

public interface OrderDao extends MongoRepository<Order, String> {

}
