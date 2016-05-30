package com.dto;

import org.springframework.stereotype.Component;

@Component
public class Company {
	String symbol,name,exch,type,exchDisp,typeDisp;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExch() {
		return exch;
	}

	public void setExch(String exch) {
		this.exch = exch;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExchDisp() {
		return exchDisp;
	}

	public void setExchDisp(String exchDisp) {
		this.exchDisp = exchDisp;
	}

	public String getTypeDisp() {
		return typeDisp;
	}

	public void setTypeDisp(String typeDisp) {
		this.typeDisp = typeDisp;
	}
	

}
