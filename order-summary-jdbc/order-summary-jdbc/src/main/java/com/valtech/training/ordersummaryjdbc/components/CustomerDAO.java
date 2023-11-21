package com.valtech.training.ordersummaryjdbc.components;

import java.util.List;

public interface CustomerDAO {

	long countCustomers();

	void createCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int id);

	List<Customer> getAllCustomers();

}