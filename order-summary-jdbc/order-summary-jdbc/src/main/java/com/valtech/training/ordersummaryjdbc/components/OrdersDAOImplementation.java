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
public class OrdersDAOImplementation implements OrdersDAO {

	public class OrdersRowMapper implements RowMapper<Orders> {

		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			Orders order = new Orders();
			order.setOrderID(rs.getInt(1));
			order.setOrderDate(rs.getDate(2));
			order.setCustomerId(rs.getInt(3));
			return order;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createOrder(Orders order) {
		String createQuery = "INSERT INTO ORDERS(ORDERDATE, CUSTOMERID) VALUES (?,?)";
		new JdbcTemplate(dataSource).update(createQuery, order.getOrderDate(), order.getCustomerId());
	}

	@Override
	public void updateOrder(Orders order) {
		String updateQuery = "UPDATE ORDERS SET ORDERDATE=?, CUSTOMERID=? WHERE ORDERID=? ";
		new JdbcTemplate(dataSource).update(updateQuery, order.getOrderDate(), order.getCustomerId(),
				order.getOrderID());
	}

	@Override
	public void deleteOrder(int id) {
		String deleteQuery = "DELETE FROM ORDERS WHERE ORDERID=?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

	@Override
	public long countOrders() {
		String countQuery = "SELECT COUNT(ORDERID) FROM ORDERS";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}

	@Override
	public List<Orders> getAllOrders() {
		String getAllQuery = "SELECT * FROM ORDERS";
		return new JdbcTemplate(dataSource).query(getAllQuery, new OrdersRowMapper());
	}

}
