package br.com.loanproject.customer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.loanproject.commons.enumerate.RiskType;

@Entity
@Table(schema="loanproject", name = "customer")
public class Customer {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID", nullable = false, length = 6)
	private long id;
	
	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	@Column(name = "INCOME", nullable = false, length = 50)
	private float income;
	
	@Column(name = "RISK_TYPE", nullable = false, length = 50)
	private RiskType riskType;
	
	@Column(name = "ADDRESS", nullable = false, length = 50)
	private String address;
	
	public Customer(String name, float income, RiskType riskType, String address) {
		super();
		this.name = name;
		this.income = income;
		this.riskType = riskType;
		this.address = address;
	}
	
	public Customer() {
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public RiskType getRiskType() {
		return riskType;
	}
	public void setRiskType(RiskType riskType) {
		this.riskType = riskType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
