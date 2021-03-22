package com.example.demo.currencydemo.dao;

import java.util.List;

import com.example.demo.currencydemo.entity.Cripto;

public interface CriptoDAO {

	public List<Cripto> findAll();
	
	public Cripto findById(int theId);
	
	public void save(Cripto theCripto);
	
	public void deleteById(int theId);
	
}
