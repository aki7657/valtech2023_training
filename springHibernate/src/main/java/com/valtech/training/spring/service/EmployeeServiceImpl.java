package com.valtech.training.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.hibernate.Employee;
import com.valtech.training.spring.dao.EmployeeDAO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	@Override
	public Employee createEmployee(Employee e) {
		e.setActive(true);
		return employeeDAO.saveEmployee(e);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee makeActive(Employee e) {
		e.setActive(true);
		return employeeDAO.updateEmployee(e);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Employee makeInactive(Employee e) {
		e.setActive(false);
		return employeeDAO.updateEmployee(e);
	}

	@Override
	public Employee incrementSalary(Employee e, float increment) {
		e.setSalary(e.getSalary() + increment);
		return employeeDAO.updateEmployee(e);
	}

	@Override
	public void incrementSalaryForAll(int increment) {
		employeeDAO.getAllEmployees().forEach(e -> e.setSalary(e.getSalary() + increment));
//		Here no need to update employee because we are using get all employees, which will automatically load all the employees from the current session and not from previous sessions(as could have happened on previous cases). In prev cases we needed to update everytime because we are directly setting employee e without checking which session we are connected to and could hence be in prev session
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}
