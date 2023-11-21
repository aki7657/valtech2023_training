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
public class CustomerDAOImplementation implements CustomerDAO {

	public class CustomerRowMapper implements RowMapper<Customer> {

		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt(1));
			customer.setCustomerAddress(rs.getString(2));
			customer.setCustomerName(rs.getString(3));
			customer.setCustomerPhoneNumber(rs.getString(4));
			return customer;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public long countCustomers() {
		String countQuery = "SELECT COUNT(CUSTOMERID) FROM CUSTOMER";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}

	@Override
	public void createCustomer(Customer customer) {
		String createQuery = "INSERT INTO CUSTOMER(CUSTOMERNAME, CUSTOMERADDRESS, CUSTOMERPHONENUMBER) VALUES (?,?,?)";
		new JdbcTemplate(dataSource).update(createQuery, customer.getCustomerName(), customer.getCustomerAddress(),
				customer.getCustomerPhoneNumber());
	}

	@Override
	public void updateCustomer(Customer customer) {
		String updateQuery = "UPDATE CUSTOMER SET CUSTOMERNAME=?, CUSTOMERADDRESS=?, CUSTOMERPHONENUMBER=? WHERE CUSTOMERID=?";
		new JdbcTemplate(dataSource).update(updateQuery, customer.getCustomerName(), customer.getCustomerAddress(),
				customer.getCustomerPhoneNumber(), customer.getCustomerId());
	}

	@Override
	public void deleteCustomer(int id) {
		String deleteQuery = "DELETE FROM CUSTOMER WHERE CUSTOMERID=?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		String getAllQuery = "SELECT * FROM CUSTOMER";
		return new JdbcTemplate(dataSource).query(getAllQuery, new CustomerRowMapper());
	}
}
