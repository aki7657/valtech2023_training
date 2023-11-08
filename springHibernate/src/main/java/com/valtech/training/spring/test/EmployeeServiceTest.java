package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.service.EmployeeService;

class EmployeeServiceTest {

	private ApplicationContext applicationContext;
	private DateFormat dateFormat;

	@BeforeEach
	void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("tx2.xml");
		dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	}

	@AfterEach
	void tearDown() throws Exception {
		((ClassPathXmlApplicationContext) applicationContext).close();
	}

	@Test
	void test() throws Exception {
		Employee employee1 = new Employee("Akhil", dateFormat.parse("28-05-2001"), 700000, 'M', false);
		EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeService");
		employee1 = employeeService.createEmployee(employee1);
		System.out.println(employee1);
		employee1 = employeeService.incrementSalary(employee1, 100000);
		System.out.println(employee1);
	}

}
