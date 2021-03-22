package com.example.demo.currencydemo.entity;

import java.io.Serializable;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cripto")
public class Cripto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cripto_name")
	private String criptoName;
	
	@Column(name = "currency")
	private String currency;

	public Cripto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCriptoName() {
		return criptoName;
	}

	public void setCriptoName(String criptoName) {
		this.criptoName = criptoName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Money [id=" + id + ", criptoName=" + criptoName + ", currency=" + currency + "]";
	}
	
	
	
	
	
}
