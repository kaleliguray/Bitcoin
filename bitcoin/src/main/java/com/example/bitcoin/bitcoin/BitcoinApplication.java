package com.example.bitcoin.bitcoin;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bitcoin.bitcoin.entity.Bitcoin;





@SpringBootApplication
public class BitcoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitcoinApplication.class, args);
		
		Bitcoin bitcoin = new Bitcoin();
		
		kaydetmek(bitcoin);
		
	}
	
	public static Bitcoin kaydetmek(Bitcoin theBitcoin) {
		
		
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
				
				theBitcoin.setId(i);
				theBitcoin.setSymbol(jsonArray.getJSONObject(i).getString("symbol"));
				theBitcoin.setPrice(jsonArray.getJSONObject(i).getString("price"));
				
				System.out.println(theBitcoin);
//				bitcoinRepository.save(theBitcoin);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return theBitcoin;
	}


}
