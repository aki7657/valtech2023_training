package com.valtech.training.springemployeemanager.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.springemployeemanager.entities.Department;
import com.valtech.training.springemployeemanager.entities.Employee;
import com.valtech.training.springemployeemanager.repositories.DepartmentRepository;
import com.valtech.training.springemployeemanager.repositories.EmployeeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DepartmentEmployeeServiceImpl implements DepartmentEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

//	@PostConstruct
//	public void populateDepartments() {
//		Department department1=new Department("Human Resources", "Ground Floor"); 
//		departmentRepository.save(department1);
//	}

	@Override
	@PostConstruct
	public void populateDepartmentAndEmployees() {
		Department department1 = new Department("Human Resources", "Ground Floor");
		departmentRepository.save(department1);
		Department department2 = new Department("Finance", "First Floor");
		departmentRepository.save(department2);

		Employee employee1 = new Employee("Akhil", 22, 1, 1, 700000);
		employeeRepository.save(employee1);
		Employee employee2 = new Employee("Murali", 22, 1, 1, 700000);
		employeeRepository.save(employee2);
		Employee employee3 = new Employee("Chandana", 22, 1, 1, 700000);
		employeeRepository.save(employee3);
		Employee employee4 = new Employee("Richa", 22, 1, 1, 700000);
		employeeRepository.save(employee4);

		employee1.setDepartment(department1);
		employee2.setDepartment(department1);
		employee3.setDepartment(department2);
		employee4.setDepartment(department2);

		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);

	}

	@Override
	public Employee createEmployee(Employee employees) {
		System.out.println(employees.getName().getClass());
		return employeeRepository.save(employees);
	}

	@Override
	public Employee updateEmployee(Employee employees) {
		return employeeRepository.save(employees);
	}

	@Override
	public Employee getEmployee(long employeeId) {
		return employeeRepository.getReferenceById(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartment(long departmentId) {
		return departmentRepository.getReferenceById(departmentId);
	}

	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}

//	public List<Employee> getEmployeeByDepartment(List<Employee> employees, long departmentId){
//		Department department1 = departmentRepository.getReferenceById(departmentId);
//		return department1.employeeRepository.findAll();
//	}

	@Override
	public Department getDepartmentWithEmployees(long departmentId) {
		Department department = departmentRepository.findById(departmentId).orElse(null);

		if (department != null) {
			// Load employees for the specified department
			List<Employee> employees = (List<Employee>) department.getEmployees();
//            department.setEmployees(employees);
		}

		return department;
	}
}
