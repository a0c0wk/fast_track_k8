package com.ibm.conversion.controller;

import com.ibm.conversion.domain.ConversionModel;
import com.ibm.conversion.service.ConvertionSvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversion")
public class ConversionController {
	Logger logger = LoggerFactory.getLogger(ConversionController.class);

    @Autowired
    ConvertionSvc conversionService;

    @GetMapping("/details/{country}")
     public ResponseEntity<ConversionModel> getConversionFactorDetail(@PathVariable("country") String country){
    	try {
    		return ResponseEntity.ok(conversionService.getConversionDetails(country));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
          
     }
    
    
    @GetMapping("/factor/{country}")
    public Double getConversionFactor(@PathVariable("country") String country){
    	logger.info("Calling controller conversion.getConversionFactor for country {}",country);
   		return conversionService.getConversionFactor(country);
		
         
    }
}
