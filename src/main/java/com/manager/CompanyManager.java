package com.manager;

import java.util.List;

import com.model.Company;

public interface CompanyManager {
	public Company addCompany(Company company, Long Id);
	public List<Company> getCompanyByProtfoliyoId(Long Id);

}
