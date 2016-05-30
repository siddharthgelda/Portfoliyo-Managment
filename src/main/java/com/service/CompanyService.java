package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.manager.CompanyManager;
import com.model.Company;

@RestController
@RequestMapping("/company")
public class CompanyService {

	@Autowired
	CompanyManager companyManager;
	
	
@RequestMapping(value = "/protfoliyo/{id}",method = RequestMethod.POST,consumes="application/json")	
	public ResponseEntity<Company> createCompany(@RequestBody Company company,@PathVariable("id") Long id) {
	Company savecompany=companyManager.addCompany(company,id);
	 return new ResponseEntity<Company>(savecompany,HttpStatus.CREATED);
	}


}
