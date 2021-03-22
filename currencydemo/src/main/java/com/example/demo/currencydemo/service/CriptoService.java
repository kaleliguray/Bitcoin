package com.example.demo.currencydemo.service;

import java.util.List;

import com.example.demo.currencydemo.entity.Cripto;

public interface CriptoService {

	public List<Cripto> findAll();
	
	public Cripto findById(int theId);
	
	public void save(Cripto theCripto);
	
	public void deleteById(int theId);
	
	
	
}
