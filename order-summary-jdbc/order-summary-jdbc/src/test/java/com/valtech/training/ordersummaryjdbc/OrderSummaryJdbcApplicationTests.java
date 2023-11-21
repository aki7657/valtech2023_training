package com.valtech.training.ordersummaryjdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.ordersummaryjdbc.components.Company;
import com.valtech.training.ordersummaryjdbc.components.CompanyDAO;
import com.valtech.training.ordersummaryjdbc.components.Customer;
import com.valtech.training.ordersummaryjdbc.components.CustomerDAO;
import com.valtech.training.ordersummaryjdbc.components.Items;
import com.valtech.training.ordersummaryjdbc.components.ItemsDAO;
import com.valtech.training.ordersummaryjdbc.components.OrderSummary;
import com.valtech.training.ordersummaryjdbc.components.OrderSummaryDAO;
import com.valtech.training.ordersummaryjdbc.components.Orders;
import com.valtech.training.ordersummaryjdbc.components.OrdersDAO;

@SpringBootTest
class OrderSummaryJdbcApplicationTests {

	@Autowired
	private CompanyDAO companyDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private ItemsDAO itemsDAO;

	@Autowired
	private OrdersDAO ordersDAO;

	DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");

	@Autowired
	private OrderSummaryDAO orderSummaryDAO;

//	@Test
//	void testCompany() {
//		assertEquals(4, companyDAO.getAllCompanies().size());
//		assertEquals(4, companyDAO.countCompanies());
//		Company company = new Company("Infosys", "Bangalore");
//		companyDAO.createCompany(company);
//		assertEquals(4, companyDAO.countCompanies());
//		System.out.println(companyDAO.getAllCompanies());
//		Company company1 = new Company(6, "Valtech2", "Mangalore");
//		companyDAO.updateCompany(company1);
//		companyDAO.deleteCompany(9);
//	}
//
//	@Test
//	void testCustomer() {
//		assertEquals(2, customerDAO.getAllCustomers().size());
//		assertEquals(2, customerDAO.countCustomers());
//		Customer customer = new Customer("Chandana", "Bangalore", "9898989898");
//		customerDAO.createCustomer(customer);
//		System.out.println(customerDAO.getAllCustomers());
//		assertEquals(3, customerDAO.countCustomers());
//		Customer customer = new Customer(3, "Richa", "Mangalore", "9879879879");
//		customerDAO.updateCustomer(customer);
//		customerDAO.deleteCustomer(3);
//	}
//	
//	@Test
//	void testItems() {
//		assertEquals(7, itemsDAO.getAllItems().size());
//		assertEquals(7, itemsDAO.countItems());
//		Items items = new Items("Apple Watch Series 8", 39999, 8);
//		itemsDAO.createItem(items);
//		Items items = new Items(13,"Apple Watch Ultra", 89999, 7);
//		itemsDAO.updateItem(items);
//		itemsDAO.deleteItem(14);
//	}
//	
//	@Test
//	void testOrders() throws ParseException {
//		assertEquals(1, ordersDAO.getAllOrders().size());
//		assertEquals(1, ordersDAO.countOrders());
//		Orders orders = new Orders(dateformat.parse("01-01-2001-01-01-01"), 2);
//		ordersDAO.createOrder(orders);
//		Orders orders = new Orders(2, dateformat.parse("11-11-2002-01-01-01"), 2);
//		ordersDAO.updateOrder(orders);
//		ordersDAO.deleteOrder(2);
//	}
//	
//	
//	@Test
//	void testOrderSummary() {
//		assertEquals(1, orderSummaryDAO.getAllOrderSummaries().size());
//		assertEquals(1, orderSummaryDAO.countOrderSummaries());
//		OrderSummary orderSummary = new OrderSummary(3, 2);
//		orderSummaryDAO.createOrderSummary(orderSummary);
//		OrderSummary orderSummary = new OrderSummary(2, 3, 1);
//		orderSummaryDAO.updateOrderSummary(orderSummary);
//		orderSummaryDAO.deleteOrderSummary(2);
//	}
}
