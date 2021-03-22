package com.example.bitcoin.bitcoin.service;

import java.util.List;

import com.example.bitcoin.bitcoin.entity.Bitcoin;



public interface BitcoinService {
	
	public List<Bitcoin> findAll();
	
	public Bitcoin findById(int theId);
	
	public void save(Bitcoin theTodos);
	
	public void deleteById(int theId);
}
