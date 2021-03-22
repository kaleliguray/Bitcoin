package com.example.demo.currencydemo.rest;

import java.awt.PageAttributes.MediaType;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.currencydemo.dao.CriptoDAO;
import com.example.demo.currencydemo.entity.Cripto;
import com.example.demo.currencydemo.service.CriptoService;
import com.fasterxml.jackson.core.JsonParser;

@RestController
@RequestMapping("/api")
public class CriptoController {
	
	private CriptoService criptoService;
	
	@Autowired
	public CriptoController(CriptoService theCriptoService) {
	
		this.criptoService = theCriptoService;
	}
	
	@GetMapping("/cripto")
//	@RequestMapping(method = RequestMethod.GET,produces = "application/json",path = "/cripto")
	public List<Cripto> findAll(){
		
		return criptoService.findAll();
	}
	
	@GetMapping("/cripto/{theId}")
	public Cripto getCripto(@PathVariable int theId) {
		
		Cripto theCripto = criptoService.findById(theId);
		
		if (theCripto == null) {
			throw new RuntimeException("Cripto Money not found " + theId);
		}
		
		return theCripto;
	}
	
	@PostMapping("/criptos")
	public Cripto addCripto(@RequestBody Cripto theCripto) {
		
		theCripto.setId(0);
		
		criptoService.save(theCripto);
		
		return theCripto;
	}
	
	@PutMapping("/criptos")
	public Cripto updateCripto(@RequestBody Cripto theCripto) {
		
		criptoService.save(theCripto);
		
		return theCripto;
		
	}
	
	@DeleteMapping("/criptos/{theId}")
	public String deleteCripto(@PathVariable int theId) {
		
		Cripto theCripto = criptoService.findById(theId);
		
		if (theCripto == null) {
			throw new RuntimeException("Cripto Money not found : " + theId);
		}
		
		criptoService.deleteById(theId);
		
		return "Deleted cripto id " + theId;
		
	}
	
	
}































