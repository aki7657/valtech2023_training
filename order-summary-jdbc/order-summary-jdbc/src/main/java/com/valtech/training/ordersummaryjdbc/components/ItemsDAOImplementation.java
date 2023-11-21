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
public class ItemsDAOImplementation implements ItemsDAO {

	public class ItemsRowMapper implements RowMapper<Items> {

		@Override
		public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
			Items item = new Items();
			item.setItemId(rs.getInt(1));
			item.setItemDescription(rs.getString(2));
			item.setUnitPrice(rs.getFloat(3));
			item.setCompanyId(rs.getInt(4));
			return item;
		}

	}

	@Autowired
	private DataSource dataSource;

	@Override
	public void createItem(Items item) {
		String createQuery = "INSERT INTO ITEMS(ITEMDESCRIPTION, UNITPRICE, COMPANYID) VALUES (?,?,?)";
		new JdbcTemplate(dataSource).update(createQuery, item.getItemDescription(), item.getUnitPrice(),
				item.getCompanyId());
	}

	@Override
	public void updateItem(Items item) {
		String updateQuery = "UPDATE ITEMS SET ITEMDESCRIPTION=?, UNITPRICE=?, COMPANYID=? WHERE ITEMID=? ";
		new JdbcTemplate(dataSource).update(updateQuery, item.getItemDescription(), item.getUnitPrice(),
				item.getCompanyId(), item.getItemId());
	}

	@Override
	public void deleteItem(int id) {
		String deleteQuery = "DELETE FROM ITEMS WHERE ITEMID=?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

	@Override
	public long countItems() {
		String countQuery = "SELECT COUNT(ITEMID) FROM ITEMS";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}

	@Override
	public List<Items> getAllItems() {
		String getAllQuery = "SELECT * FROM ITEMS";
		return new JdbcTemplate(dataSource).query(getAllQuery, new ItemsRowMapper());
	}

}
