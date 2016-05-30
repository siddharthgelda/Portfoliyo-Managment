package com.dto;

import java.io.Serializable;

public class StockRootResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public StockResponse ResultSet;

	public StockResponse getResultSet() {
		return ResultSet;
	}

	public void setResultSet(StockResponse resultSet) {
		ResultSet = resultSet;
	}
	

}
