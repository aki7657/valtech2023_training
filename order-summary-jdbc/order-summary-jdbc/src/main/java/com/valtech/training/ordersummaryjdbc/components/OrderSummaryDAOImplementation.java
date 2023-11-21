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
public class OrderSummaryDAOImplementation implements OrderSummaryDAO {

	public class OrderSummaryRowMapper implements RowMapper<OrderSummary> {

		@Override
		public OrderSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderSummary orderSummary = new OrderSummary();
			orderSummary.setOrderSummaryId(rs.getInt(1));
			orderSummary.setQuantity(rs.getInt(2));
			orderSummary.setOrderId(rs.getInt(3));
			return orderSummary;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createOrderSummary(OrderSummary orderSummary) {
		String createQuery = "INSERT INTO ORDERSUMMARY(QUANTITY, ORDERID) VALUES (?,?)";
		new JdbcTemplate(dataSource).update(createQuery, orderSummary.getQuantity(), orderSummary.getOrderId());
	}

	@Override
	public void updateOrderSummary(OrderSummary orderSummary) {
		String updateQuery = "UPDATE ORDERSUMMARY SET QUANTITY=?, ORDERID=? WHERE ORDERSUMMARYID=? ";
		new JdbcTemplate(dataSource).update(updateQuery, orderSummary.getQuantity(), orderSummary.getOrderId(),
				orderSummary.getOrderSummaryId());
	}

	@Override
	public void deleteOrderSummary(int id) {
		String deleteQuery = "DELETE FROM ORDERSUMMARY WHERE ORDERSUMMARYID=?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

	@Override
	public long countOrderSummaries() {
		String countQuery = "SELECT COUNT(ORDERSUMMARYID) FROM ORDERSUMMARY";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}

	@Override
	public List<OrderSummary> getAllOrderSummaries() {
		String getAllQuery = "SELECT * FROM ORDERSUMMARY";
		return new JdbcTemplate(dataSource).query(getAllQuery, new OrderSummaryRowMapper());
	}

}
