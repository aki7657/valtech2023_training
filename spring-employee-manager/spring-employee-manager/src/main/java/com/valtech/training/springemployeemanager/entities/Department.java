package com.valtech.training.springemployeemanager.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long departmentId;
	private String departmentName;
	private String departmentLocation;

	@OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "department")
	private Set<Employee> employees;

	public Department() {
		super();
	}

	public Department(String departmentName, String departmentLocation, Set<Employee> employees) {
		super();
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
		this.employees = employees;
	}

	public Department(String departmentName, String departmentLocation) {
		super();
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}

	public void addEmployee(Employee employees) {
		if (getEmployees() == null) {
			setEmployees(new HashSet<Employee>());
		}
		getEmployees().add(employees);
		employees.setDepartment(this);
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
