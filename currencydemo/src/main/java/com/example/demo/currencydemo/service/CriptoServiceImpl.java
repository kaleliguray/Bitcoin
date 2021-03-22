package com.example.demo.currencydemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.currencydemo.dao.CriptoDAO;
import com.example.demo.currencydemo.entity.Cripto;

@Service
public class CriptoServiceImpl implements CriptoService{
	
	private CriptoDAO criptoDAO;
	
	@Autowired
	public CriptoServiceImpl(CriptoDAO theCriptoDAO) {
		this.criptoDAO = theCriptoDAO;
	}

	@Override
	@Transactional
	public List<Cripto> findAll() {
		
		return criptoDAO.findAll();
	}

	@Override
	@Transactional
	public Cripto findById(int theId) {

		return criptoDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Cripto theCripto) {

		criptoDAO.save(theCripto);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		criptoDAO.deleteById(theId);
	}


}































