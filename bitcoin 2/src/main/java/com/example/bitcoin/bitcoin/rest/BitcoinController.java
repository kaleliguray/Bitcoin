package com.example.bitcoin.bitcoin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bitcoin.bitcoin.entity.Bitcoin;
import com.example.bitcoin.bitcoin.service.BitcoinService;


@RestController
@RequestMapping("/api")
public class BitcoinController {
	
	private BitcoinService bitcoinService;
	
	@Autowired
	public BitcoinController(BitcoinService theBitcoinService) {
		this.bitcoinService = theBitcoinService;
	}
	
	@GetMapping("/bitcoin")
	public List<Bitcoin> findAll(){
		
		return bitcoinService.findAll();
	}
	
	@GetMapping("/bitcoin/{theId}")
	public Bitcoin getBitcoin(@PathVariable int theId) {
		
		Bitcoin theBitcoin = bitcoinService.findById(theId);
		
		if (theBitcoin == null) {
			throw new RuntimeException("Bitcoin not found " + theId);
		}
		
		return theBitcoin;
	}
	
	@PostMapping("/bitcoins")
	public Bitcoin addTodos(@RequestBody Bitcoin theBitcoin) {

		theBitcoin.setId(0);
		
		bitcoinService.save(theBitcoin);
		
		return theBitcoin;
	}
	
	@PutMapping("/bitcoins")
	public Bitcoin updatetTodos(@RequestBody Bitcoin theBitcoin) {
		
		
		bitcoinService.save(theBitcoin);
		
		return theBitcoin;
		
	}
	
	@DeleteMapping("/bitcoin/{theId}")
	public String deleteBitcoin(@PathVariable int theId) {
		
		Bitcoin theBitcoin = bitcoinService.findById(theId);
		
		if (theBitcoin == null) {
			throw new RuntimeException("Todos not found : " + theId);
		}
		
		bitcoinService.deleteById(theId);
		
		return "Deleted todos id " + theId;
		
	}

	
}













