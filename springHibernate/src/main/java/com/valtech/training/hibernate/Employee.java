package com.valtech.training.hibernate;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
// It is mandatory for every entity to have a primary key 
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//	Identity will work as auto increment in mysql
	private int id;
	private String name;
	@Basic @Temporal(TemporalType.DATE)
	private Date dob;
	private float salary;
	private char gender;
	private boolean active;
	@Version
	private int version;
//	A bean is a java class with a parameterless constructor
//	Both class and constructor should be public and this should have getters and setters to be called a java bean

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Employee() {

	}

	public Employee(int id, String name, Date dob, float salary, char gender, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.gender = gender;
		this.active = active;
	}

	public Employee(String name, Date dob, float salary, char gender, boolean active) {
		super();
		this.name = name;
		this.dob = dob;
		this.salary = salary;
		this.gender = gender;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + ", gender=" + gender
				+ ", active=" + active + ", version=" + version + "]";
	}

}
