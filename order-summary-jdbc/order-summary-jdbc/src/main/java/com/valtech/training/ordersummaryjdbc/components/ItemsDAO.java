package com.valtech.training.ordersummaryjdbc.components;

import java.util.List;

public interface ItemsDAO {

	void createItem(Items item);

	void updateItem(Items item);

	void deleteItem(int id);

	long countItems();

	List<Items> getAllItems();

}