package com.valtech.training.springemployeemanager.services;

import java.util.List;

import javax.annotation.PostConstruct;

import com.valtech.training.springemployeemanager.entities.Department;
import com.valtech.training.springemployeemanager.entities.Employee;

public interface DepartmentEmployeeService {


	Employee createEmployee(Employee employees);

	Employee updateEmployee(Employee employees);

	Employee getEmployee(long employeeId);

	List<Employee> getAllEmployees();

	Department createDepartment(Department department);

	Department updateDepartment(Department department);

	Department getDepartment(long departmentId);

	List<Department> getAllDepartment();

	Department getDepartmentWithEmployees(long departmentId);

}