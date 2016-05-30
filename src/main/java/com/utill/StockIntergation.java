package com.utill;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dto.*;
import com.exception.CommuncationException;
@Component
public interface StockIntergation {
	public List<Company> findCompanys(String query)throws CommuncationException;
	public List<Stock> findStocks(String query)throws CommuncationException;

}
