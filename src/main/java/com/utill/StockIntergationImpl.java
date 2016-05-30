package com.utill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dto.Company;
import com.dto.Stock;
import com.dto.StockRootResponse;
import com.exception.CommuncationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.net.SyslogOutputStream;

@Component
public class StockIntergationImpl implements StockIntergation{

	
	private RestTemplate restTemplate;
	@Override
	public List<Company> findCompanys(String query)throws CommuncationException {
		restTemplate=new RestTemplate();
		String url = "https://s.yimg.com/aq/autoc?query="+query+"&region=IN&lang=en-IN";
		ResponseEntity<StockRootResponse> response=restTemplate.getForEntity(url, StockRootResponse.class);
		if(response.getStatusCode().equals(HttpStatus.OK))
		return response.getBody().getResultSet().getResult();
		else
			throw new CommuncationException();
	}
	@Override
	public List<Stock> findStocks(String query) throws CommuncationException {
		restTemplate = new RestTemplate();
		String url = "http://finance.yahoo.com/webservice/v1/symbols/" + query + "/quote?format=json";
		Map result = restTemplate.getForObject(url, HashMap.class);
		if(result==null)
			throw new CommuncationException();
		Map resources = (Map) result.get("list");
		List<Map<String, String>> resource = (List<Map<String, String>>) resources.get("resources");
		Iterator<Map<String, String>> it=resource.listIterator();
		List<Stock> stocks=new ArrayList<Stock>();
		while(it.hasNext()){
		Stock stock = new Stock();	
		Map one = it.next();
		Map fields = (Map) one.get("resource");
		Map field = (Map) fields.get("fields");
		stock.setName(field.get("name").toString());
		stock.setPrice(field.get("price").toString());
		stock.setSymbol(field.get("symbol").toString());
		stock.setTs(field.get("ts").toString());
		stock.setType(field.get("type").toString());
		stock.setUtctime(field.get("utctime").toString());
		stock.setVolume(field.get("volume").toString());
		stocks.add(stock);
		}
		return stocks;
			}

}
