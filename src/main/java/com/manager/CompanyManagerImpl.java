package com.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Company;
import com.model.Portfoliyo;
import com.repository.CompanyRepository;
import com.repository.PortfoliyoRepository;
@Component
public class CompanyManagerImpl implements CompanyManager {

	
	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private 	PortfoliyoRepository portfoliyoRepository;
	
	

	@Override
	public Company addCompany(Company company, Long id) {
		Portfoliyo portfoliyo=portfoliyoRepository.getOne(id);
		company.setPortfoliyo(portfoliyo);
		 return companyRepository.save(company);
	}



	@Override
	public List<Company> getCompanyByProtfoliyoId(Long Id) {
		List<Company> companys=companyRepository.findByPortfoliyo(Id);
		return companys;
	}





}
