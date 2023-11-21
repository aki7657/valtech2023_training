package com.valtech.training.ordersummaryjdbc.components;

import java.util.List;

public interface OrdersDAO {

	void createOrder(Orders order);

	void updateOrder(Orders order);

	void deleteOrder(int id);

	long countOrders();

	List<Orders> getAllOrders();

}