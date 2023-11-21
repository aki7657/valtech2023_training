package com.valtech.training.ordersummaryjdbc.components;

import java.util.List;

public interface CompanyDAO {

	long countCompanies();

	void createCompany(Company company);

	List<Company> getAllCompanies();

	void updateCompany(Company company);

	void deleteCompany(int id);

}