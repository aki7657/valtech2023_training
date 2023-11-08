package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.HelloWorld;
import com.valtech.training.spring.Line;
import com.valtech.training.spring.SimpleInterest;
import com.valtech.training.spring.UtilsBean;

class IOCTest {

	private ApplicationContext appCtx;
	private ApplicationContext childAppCtx;

	@BeforeEach
	void initialize() {
		appCtx = new ClassPathXmlApplicationContext("ioc.xml");
		childAppCtx = new ClassPathXmlApplicationContext(new String[] { "ioc-child.xml" }, appCtx);
	}

	@Test
	void testChildAppCtx() {
		Line line = (Line) childAppCtx.getBean("line");
		System.out.println(line);
	}

	@Test
	void testUtils() {
		UtilsBean ub = (UtilsBean) appCtx.getBean(UtilsBean.class);
		System.out.println(ub.getNames());
		System.out.println(ub.getSettings());
		System.out.println(ub.getLinePoints());
	}

	@Test
	void testSimpleInterest() {
		SimpleInterest si = appCtx.getBean(SimpleInterest.class);
		System.out.println(si.computeInterest(10000, 4, 12));
	}

	@Test
	void testLine() {
		System.out.println(appCtx.getBean("l1"));
	}

	@Test
	void test() {
		HelloWorld hw = (HelloWorld) appCtx.getBean("hw");
		assertEquals("Hello World", hw.hello("World"));
	}

	@Test
	void testPoint() {
		System.out.println(appCtx.getBean("p1"));
		assertNotEquals(appCtx.getBean("p1"), appCtx.getBean("p1"));
	}

	@Test
	void testPointSetterInjection() {
		System.out.println(appCtx.getBean("p2"));
	}

}
