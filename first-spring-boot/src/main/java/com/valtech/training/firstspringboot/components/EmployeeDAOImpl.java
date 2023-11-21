package com.valtech.training.firstspringboot.components;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.valtech.training.firstspringboot.components.EmployeeDAOImpl.EmployeeRowMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	public class EmployeeRowMapper implements RowMapper<EmployeeD> {

		@Override
		public EmployeeD mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeD e = new EmployeeD();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setExperience(rs.getInt(4));
			e.setSeniority(rs.getInt(5));
			e.setSalary(rs.getInt(6));
			e.setDeptId(rs.getInt(7));
			return e;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public long countEmployee() {
		String countQry = "SELECT COUNT(ID) FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).queryForObject(countQry, Long.class);
	}

	// Create operation (C)
	@Override
	public void createEmployee(EmployeeD emp) {
		String createQry = "INSERT INTO EMPLOYEE (NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID) VALUES(?,?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary());
	}

	// Read Operation (R)
	@Override
	public List<EmployeeD> getAllEmployees() {
//		String selectAllQuery = "SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY,DEPTID FROM EMPLOYEE";
		String selectAllQuery = "SELECT * FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).query(selectAllQuery, new EmployeeRowMapper());
	}

	// Update operation (U)
	@Override
	public void updateEmployee(EmployeeD emp) {
		String updateQry = "UPDATE EMPLOYEE SET NAME=?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=?,DEPTID=? WHERE ID=?";
		new JdbcTemplate(dataSource).update(updateQry, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getDeptId(), emp.getId());
	}

	// Delete operation (D)
	@Override
	public void deleteEmployee(int id) {
		String deleteQry = "DELETE FROM EMPLOYEE WHERE ID=?";
		new JdbcTemplate(dataSource).update(deleteQry, id);
	}

	@Override
	public void getListOfEmployeeinEachDepartment() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeD> getEmployeeByDeptLocation(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeD> getEmployeeByDeptName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeD> getEmployeeAgeBetween(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeD> getEmployeeBySeniority(int limitVal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeD> getEmployeeSalaryGreater(int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeD> getEmployeeSalaryLesser(int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeD getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
