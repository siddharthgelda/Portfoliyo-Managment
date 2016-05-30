package com.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dto.*;
import com.exception.CommuncationException;
import com.exception.InvalidParameterException;
import com.google.common.net.MediaType;
import com.manager.PortfoliyoManager;

import com.model.Portfoliyo;
import com.validate.RequestValidator;

@RestController
@RequestMapping("/prorfoliyo")
public class PortfoliyoService {

	@Autowired
	private RequestValidator validator;

	@Autowired
	PortfoliyoManager manager;

	@RequestMapping(value = "/find/company/{query}", method = RequestMethod.GET)
	
	public ResponseEntity<List<Company>> getCompanyList(@PathVariable("query") String query) {
		try {
			validator.findCompanyRequestValidate(query);
			List<com.dto.Company> companys = manager.getCompanys(query);
			return new ResponseEntity<List<Company>>(companys, HttpStatus.OK);
		} catch (InvalidParameterException e) {
			return new ResponseEntity<List<Company>>(HttpStatus.BAD_REQUEST);
		} catch (CommuncationException e) {			
			return new ResponseEntity<List<Company>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@RequestMapping(value = "/find/stock/{query}", method = RequestMethod.GET)
	
	public ResponseEntity<List<Stock>> getStock(@PathVariable("query") String query) {
		try {
			validator.findStockRequestValidate(query);
			List<Stock> stocks = manager.getStocks(query);
			return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
		} catch (InvalidParameterException e) {
			return new ResponseEntity<List<Stock>>(HttpStatus.BAD_REQUEST);
		} catch (CommuncationException e) {			
			return new ResponseEntity<List<Stock>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}catch(Exception e)
		{return new ResponseEntity<List<Stock>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
@RequestMapping(method = RequestMethod.POST,consumes="application/json")	
	public ResponseEntity<Portfoliyo> createPortfoliyo(@RequestBody Portfoliyo portfoliyo) {
		try {
			validator.createPorfoliyoRequestValidate(portfoliyo);
			Portfoliyo potfoliyoResponse = manager.createPortfoliyo(portfoliyo);
			return new ResponseEntity<Portfoliyo>(potfoliyoResponse, HttpStatus.OK);
		} catch (InvalidParameterException e) {
			return new ResponseEntity<Portfoliyo>(HttpStatus.BAD_REQUEST);
		} catch(Exception e)
		{e.printStackTrace();
			return new ResponseEntity<Portfoliyo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
@RequestMapping(value = "/{id}",method = RequestMethod.GET)	
public ResponseEntity<Portfoliyo> getPorfoliyo(@PathVariable("id") Long Id) {
	return new ResponseEntity<Portfoliyo>(manager.getPortfoliyo(Id), HttpStatus.OK);
	
	}

}
