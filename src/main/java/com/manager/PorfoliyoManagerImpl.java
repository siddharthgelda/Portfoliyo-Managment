package com.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dto.Company;
import com.dto.Stock;
import com.exception.CommuncationException;
import com.model.Portfoliyo;
import com.repository.PortfoliyoRepository;
import com.utill.StockIntergation;
@Component
public class PorfoliyoManagerImpl implements PortfoliyoManager {
	@Autowired
	private StockIntergation stockintergation;
	
	@Autowired
	PortfoliyoRepository portfoliyoRepository;
	
	@Override
	public List<Company> getCompanys(String query) throws CommuncationException {
		return stockintergation.findCompanys(query);
	}

	@Override
	public List<Stock> getStocks(String query) throws CommuncationException {
		return stockintergation.findStocks(query);
	}

	@Override
	public Portfoliyo createPortfoliyo(Portfoliyo portfoliyo) {
		
		return portfoliyoRepository.save(portfoliyo);
	}

	@Override
	public Portfoliyo getPortfoliyo(Long Id) {
		
		return portfoliyoRepository.findById(Id);
	}

}
