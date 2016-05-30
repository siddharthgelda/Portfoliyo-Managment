package com.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "portfoliyo",schema="AMIT")
@Table(name="portfoliyo")
public class Portfoliyo {
	@Id
	@GeneratedValue
    @Column(name="id")
	private Long id;
	
	@NotNull
	@Column(name="userId")
	private Long userId;
	@NotNull
	@Column(name="name")
	private String name;
	
	@Column(name="created_on")
	private Date created_on;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "portfoliyo",fetch = FetchType.EAGER)
	   	private Set<Company> companys;
	public Portfoliyo()
	{
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Set<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(Set<Company> companys) {
		this.companys = companys;
	}
	
}
