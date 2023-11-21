package com.valtech.training.ordersummaryjdbc.components;

import java.util.List;

public interface OrderSummaryDAO {

	void createOrderSummary(OrderSummary orderSummary);

	void updateOrderSummary(OrderSummary orderSummary);

	void deleteOrderSummary(int id);

	long countOrderSummaries();

	List<OrderSummary> getAllOrderSummaries();

}