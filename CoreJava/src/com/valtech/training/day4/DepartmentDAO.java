package com.valtech.training.day4;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

	void createDepartment(DepartmentD dept) throws SQLException;

	List<DepartmentD> getDepartments() throws SQLException;

	void updateDepartment(DepartmentD dept) throws SQLException;

	void deleteDepartment(int id) throws SQLException;

	DepartmentD getDepartment(int id) throws SQLException;

}