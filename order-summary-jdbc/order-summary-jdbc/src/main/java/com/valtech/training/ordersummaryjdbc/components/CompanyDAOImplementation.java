package com.valtech.training.ordersummaryjdbc.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyDAOImplementation implements CompanyDAO {

	public class CompanyRowMapper implements RowMapper<Company> {

		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			Company company = new Company();
			company.setCompanyId(rs.getInt(1));
			company.setCompanyAddress(rs.getString(2));
			company.setCompanyName(rs.getString(3));
			return company;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public long countCompanies() {
		String countQuery = "SELECT COUNT(COMPANYID) FROM COMPANY";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}

	@Override
	public void createCompany(Company company) {
		String createQuery = "INSERT INTO COMPANY(COMPANYNAME, COMPANYADDRESS) VALUES (?,?)";
		new JdbcTemplate(dataSource).update(createQuery, company.getCompanyName(), company.getCompanyAddress());
	}

	@Override
	public List<Company> getAllCompanies() {
		String getAllQuery = "SELECT * FROM COMPANY";
		return new JdbcTemplate(dataSource).query(getAllQuery, new CompanyRowMapper());
	}

	@Override
	public void updateCompany(Company company) {
		String updateQuery = "UPDATE COMPANY SET COMPANYNAME=?, COMPANYADDRESS=? WHERE COMPANYID=?";
		new JdbcTemplate(dataSource).update(updateQuery, company.getCompanyName(), company.getCompanyAddress(),
				company.getCompanyId());
	}

	@Override
	public void deleteCompany(int id) {
		String deleteQuery = "DELETE FROM COMPANY WHERE COMPANYID=?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

}
