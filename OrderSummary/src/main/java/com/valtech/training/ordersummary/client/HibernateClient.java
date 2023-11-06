package com.valtech.training.ordersummary.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.ordersummary.Company;
import com.valtech.training.ordersummary.Customer;
import com.valtech.training.ordersummary.Items;
import com.valtech.training.ordersummary.OrderSummary;
import com.valtech.training.ordersummary.Orders;

public class HibernateClient {

	public static void main(String[] args) throws Exception {
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.addAnnotatedClass(Customer.class);
		configuration.addAnnotatedClass(Orders.class);
		configuration.addAnnotatedClass(Items.class).addAnnotatedClass(OrderSummary.class);
		configuration.addAnnotatedClass(Company.class);
		SessionFactory sesFac = configuration.buildSessionFactory();
		Session session1 = sesFac.openSession();
		Transaction tx1 = session1.beginTransaction();
		
//		session1.persist(new Customer("Akhil", "701/Tower 2, Harmony Apartments, Nirvana Country, Gurgaon", "9910369104"));
		Customer customer1 = new Customer("Akhil", "701/Tower 2, Harmony Apartments, Nirvana Country, Gurgaon", "9910369104");
		Orders order1 = new Orders(dateformat.parse("01-01-2001-01-01-01"));
		Items item1 = new Items("iPhone 15", 79999);
		Items item2 = new Items("iPhone 14", 59999);
		OrderSummary orderSummary1 = new OrderSummary(1);
		Company company1 = new Company("Valtech", "J.P Nagar, 3rd Phase, Bangalore");
		
		customer1.addOrder(order1);
		orderSummary1.addItems(item1);
		orderSummary1.addItems(item2);
		company1.addItems(item1);
		company1.addItems(item2);

//		item1.setOrderSummary(orderSummary1);
		order1.setCustomerID(customer1);
		orderSummary1.setOrder(order1);
		
		session1.persist(customer1);
		session1.persist(order1);
		session1.persist(item1);
		session1.persist(item2);
		session1.persist(orderSummary1);
		
		tx1.commit();
		session1.close();
		sesFac.close();
	}

}
