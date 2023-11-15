package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.EmployeeDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.service.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {

	@Autowired
	private HelloWorld helloWorld;

	@Autowired
	EmployeeDAO employeeDAO;

	@Autowired
	private OrderService orderService;
	
//	@Autowired
//	private SimpleInterest simpleInterest;
//	
//	@Test
//	void testSimpleInterest() {
//		simpleInterest.computeInterest(20000, 5, 1);
//	}

	@Test
	void testOrders() {
		Order order = new Order("iPhone 14 Pro", 25, "Apple iPhone", LocalDate.of(2023, 11, 8));
		orderService.createOrder(order);
		assertEquals(4, order.getId());
		assertTrue(orderService.getAllOrders().size() > 0);
	}

	@Test
	void testEmployeeDao() {
		assertEquals(4, employeeDAO.countEmployee());
		assertEquals(4, employeeDAO.getAllEmployees().size());
	}

	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}

}
