package com.example.bitcoin.bitcoin.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bitcoin.bitcoin.dao.BitcoinRepository;
import com.example.bitcoin.bitcoin.entity.Bitcoin;



@Service
public class BitcoinServiceImpl implements BitcoinService {

	private BitcoinRepository bitcoinRepository;
	
	@Autowired
	public BitcoinServiceImpl(BitcoinRepository theBitcoinRepository) {
		this.bitcoinRepository = theBitcoinRepository;
	}
	
	@Override
	public List<Bitcoin> findAll() {
		Bitcoin bitcoin = new Bitcoin();
		
		kaydetmek(bitcoin);
		
		parseJsonObject();
		
		return bitcoinRepository.findAll();
	}

	@Override
	public Bitcoin findById(int theId) {
		Optional<Bitcoin> result = bitcoinRepository.findById(theId);
		
		Bitcoin theBitcoin = null;
		
		
		if (result.isPresent()) {
			
			theBitcoin = result.get();
		} else {
			throw new RuntimeException("Did not find todos id : " + theId);
		}
		
		return theBitcoin;
	}

	@Override
	public void save(Bitcoin theBitcoin) {
		
		bitcoinRepository.save(theBitcoin);
		
	}

	@Override
	public void deleteById(int theId) {
		
		
		bitcoinRepository.deleteById(theId);
		
	}
	
	public void parseJsonObject() {
		
		try {

			URL url = new URL("https://api1.binance.com/api/v3/ticker/price");

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setRequestMethod("GET");

			String line = "";

			InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());

			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder response = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {

				response.append(line);

			}

			bufferedReader.close();
			System.out.println("Response : " + response.toString());
			
			JSONArray jsonArray = new JSONArray(response.toString());
			
			Bitcoin theBitcoin = new Bitcoin();
			
			FileWriter mydata = new FileWriter("data/bitcoin.txt");
			
			for (int i = 0; i < jsonArray.length(); i++) {
				
				theBitcoin.setSymbol(jsonArray.getJSONObject(i).getString("symbol"));
				theBitcoin.setPrice(jsonArray.getJSONObject(i).getString("price"));
				
				System.out.println(theBitcoin);
				mydata.write(theBitcoin.toString());
				bitcoinRepository.save(theBitcoin);
			}
			
			
			mydata.flush();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
	}
	
	public Bitcoin kaydetmek(Bitcoin theBitcoin) {
		
		
		try {

			URL url = new URL("https://api1.binance.com/api/v3/ticker/price");

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setRequestMethod("GET");

			String line = "";

			InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());

			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder response = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {

				response.append(line);

			}

			bufferedReader.close();
			System.out.println("Response : " + response.toString());
			
			JSONArray jsonArray = new JSONArray(response.toString());
			
			for (int i = 0; i < jsonArray.length(); i++) {
				
//				theBitcoin.setId(i);
				theBitcoin.setSymbol(jsonArray.getJSONObject(i).getString("symbol"));
				theBitcoin.setPrice(jsonArray.getJSONObject(i).getString("price"));
				
				System.out.println(theBitcoin);
				bitcoinRepository.save(theBitcoin);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return theBitcoin;
	}

	

	public int bitcoiId(int id) {
		
		Bitcoin theBitcoin = new Bitcoin();
		int a = 0;
		
		try {

			URL url = new URL("https://api1.binance.com/api/v3/ticker/price");

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setRequestMethod("GET");

			String line = "";

			InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());

			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder response = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {

				response.append(line);

			}

			bufferedReader.close();
			System.out.println("Response : " + response.toString());
			
			JSONArray jsonArray = new JSONArray(response.toString());
			
			
			for (int i = 0; i < jsonArray.length(); i++) {
				

				theBitcoin.setSymbol(jsonArray.getJSONObject(i).getString("symbol"));
				theBitcoin.setPrice(jsonArray.getJSONObject(i).getString("price"));
				
				System.out.println(theBitcoin);
				
			}
				theBitcoin.setId(id);
				System.out.println(theBitcoin);
				a = theBitcoin.getId();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}


}
