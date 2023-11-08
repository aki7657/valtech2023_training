package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.valtech.training.hibernate.Employee;

@Repository
//We should always define DAO with the repository annotation
//@service will be needed for all classes that are service classes, they will need tx support
// @controller for all the classes that are to be used for presentation logic
// @component they are general classes which have to be registered with BeanFactory
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void deleteEmployee(Employee employee1) {
		Session session1 = sessionFactory.getCurrentSession();
		session1.delete(employee1);
	}

	@Override
	public Employee saveEmployee(Employee employee1) {
		Session session1 = sessionFactory.getCurrentSession();
		session1.persist(employee1);
		return employee1;
	}

	@Override
	public Employee loadEmployee(int empId) {
		Session session1 = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session1.load(Employee.class, empId);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee1) {
		Session session1 = sessionFactory.getCurrentSession();
		employee1 = (Employee) session1.merge(employee1);
		return employee1;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session1 = sessionFactory.getCurrentSession();
		List<Employee> employees = session1.createQuery("from employee e").list();
		return employees;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
