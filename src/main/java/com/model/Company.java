package com.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.Portfoliyo;
@Entity
//@Table(name = "company",schema="AMIT")
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@NotNull
	@Column(name="name")
	private String name;
	@NotNull
	@Column(name="symbol")
	private String symbol;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "portfoliyo")
	private Portfoliyo portfoliyo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Portfoliyo getPortfoliyo() {
		return portfoliyo;
	}
	public void setPortfoliyo(Portfoliyo portfoliyo) {
		this.portfoliyo = portfoliyo;
	}
	

}
