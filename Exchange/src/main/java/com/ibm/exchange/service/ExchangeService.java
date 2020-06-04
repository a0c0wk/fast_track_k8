package com.ibm.exchange.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.exchange.controller.ExchangeController;

@Service
public class ExchangeService {
	
	Logger logger = LoggerFactory.getLogger(ExchangeService.class);
	
	@Autowired
	RestTemplate template;
	
	String serviceURL = "http://conversion-service/conversion/factor/{country}";
	
	
	public Double getCurrencyConversionFactor(String country) {
		ResponseEntity<Double> factor =null;
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("country", country);
		
		logger.info("Calling Exchange service via url: {} ",serviceURL);
		factor= template.getForEntity(serviceURL, Double.class, uriVariables);
		
		return factor.getBody().doubleValue();
	}
	

}
