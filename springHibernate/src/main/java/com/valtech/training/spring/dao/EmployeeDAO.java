package com.valtech.training.spring.dao;

import java.util.List;

import com.valtech.training.hibernate.Employee;

public interface EmployeeDAO {

	void deleteEmployee(Employee employee1);

	Employee saveEmployee(Employee employee1);

	Employee loadEmployee(int empId);

	Employee updateEmployee(Employee employee1);

	List<Employee> getAllEmployees();

}