package com.ibm.exchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.exchange.client.FeignClientProxy;
import com.ibm.exchange.domain.ExchangeData;
import com.ibm.exchange.service.ExchangeService;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {
	
	Logger logger = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	FeignClientProxy proxyClient;
	
	@Autowired
	ExchangeService exchangeSvc;
	
	
	
	@GetMapping("/feign/{country}/{qty}")
	public ResponseEntity<ExchangeData> getCurrencyConverted(@PathVariable("country") String country,@PathVariable("qty") int qty )
	{
		Double factor = proxyClient.getConversionFactor(country);
		
		logger.info("Recieved response through Feign client: country: {}, :::  Factor: {} ",country,factor);
		
		return ResponseEntity.ok(new ExchangeData(country,factor,qty,qty*factor));
	}
	

	
	
	@GetMapping("/resteureka/{country}/{qty}")
	public ResponseEntity<ExchangeData> getCurrencyConvertedViaRestEureka(@PathVariable("country") String country,@PathVariable("qty") int qty )
	{		
	
		Double factor = exchangeSvc.getCurrencyConversionFactor(country);
		logger.info("Recieved response through restTemplate client: country: {}, :::  Factor: {} ",country,factor);
		
		return ResponseEntity.ok(new ExchangeData(country,factor,qty,qty*factor));
	}
	
}
