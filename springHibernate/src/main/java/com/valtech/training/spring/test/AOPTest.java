package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Arithmetic;

class AOPTest {

	private ClassPathXmlApplicationContext applicationContext;

	@BeforeEach
	void initialize() {
		applicationContext = new ClassPathXmlApplicationContext("aop.xml");
	}

	@AfterEach
	void closeall() {
		applicationContext.close();
	}

	@Test
	void test() {
		Arithmetic arithmetic1 = applicationContext.getBean(Arithmetic.class);
		System.out.println(arithmetic1.getClass().getName());
		assertEquals(5, arithmetic1.add(2, 3));
		assertEquals(1, arithmetic1.sub(2, 3));
		assertEquals(5, arithmetic1.add(3, 2));
		assertEquals(6, arithmetic1.mul(2, -3));
		assertEquals(1, arithmetic1.div(2, 2));
		try {
			arithmetic1.div(5, 0);
			fail("No excpetion occured");
		} catch (Exception e) {
		}
	}

}
