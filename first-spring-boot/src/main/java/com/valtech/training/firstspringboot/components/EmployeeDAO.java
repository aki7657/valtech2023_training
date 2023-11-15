package com.valtech.training.firstspringboot.components;


import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	
	public void getListOfEmployeeinEachDepartment() ;
	
	List<EmployeeD> getEmployeeByDeptLocation(String name) ;
	
	List<EmployeeD> getEmployeeByDeptName(String name) ;
	
	List<EmployeeD> getEmployeeAgeBetween(int min,int max) ;
	
	List<EmployeeD> getEmployeeBySeniority(int limitVal) ;
	
	List<EmployeeD> getEmployeeSalaryGreater(int amount) ;
	
	List<EmployeeD> getEmployeeSalaryLesser(int amount) ;
	
	public long countEmployee() ;

	void deleteEmployee(int id) ;

	void updateEmployee(EmployeeD emp) ;

	void createEmployee(EmployeeD emp) ;

	List<EmployeeD> getAllEmployees() ;

	EmployeeD getEmployee(int id) ;

}
