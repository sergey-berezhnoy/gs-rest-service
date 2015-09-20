package hello.service;

import hello.domain.Order;
import hello.domain.OrderRequest;

public interface OrderService {
	public Order createAnOrder(OrderRequest orderRequest);
}
