package com.dto;

import java.io.Serializable;
import java.util.List;

import com.dto.*;
public class StockResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	public String Query;
	public List<Company> Result;
	public String getQuery() {
		return Query;
	}
	public void setQuery(String query) {
		Query = query;
	}
	public List<Company> getResult() {
		return Result;
	}
	public void setResult(List<Company> result) {
		Result = result;
	}
	
	
}
