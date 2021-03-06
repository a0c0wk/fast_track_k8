package com.ibm.conversion.service;

import com.ibm.conversion.dao.ConversionRepository;
import com.ibm.conversion.domain.ConversionModel;
import com.ibm.conversion.entity.ConversionTable;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional
public class ConvertionSvc {
	
	Logger logger = LoggerFactory.getLogger(ConvertionSvc.class);

    @Autowired
    Environment environment;

    @Autowired
    ConversionRepository conversionRepository;


    public ConversionModel getConversionDetails(String country){

        ConversionTable conversionTable = conversionRepository.findByCountryCode (country);

        int port =Integer.parseInt (environment.getProperty ("local.server.port"));
        if(null != conversionTable)
            return ConversionModel.builder().countryCode(conversionTable.getCountryCode ()).
            		                         conversionFactor(conversionTable.getConversionFactor ()).
            		                         port (port).build ();
        else
            return null;
    }


    @HystrixCommand(fallbackMethod = "defaultFactor")
	public Double getConversionFactor(String country) {
    	logger.info("Calling service conversion.getConversionFactor for country {}",country);
		ConversionTable conversionTable = conversionRepository.findByCountryCode (country);
		
		return conversionTable.getConversionFactor();
	}
    
    
    public Double defaultFactor(String country){
    	System.out.println(" Called Circuit breaker method ");
    	return -0.0;
    }


	public void addConversionFactor(ConversionModel model) {
		// TODO Auto-generated method stub
		if(null == conversionRepository.findByCountryCode(model.getCountryCode())){
			ConversionTable conversionTable = new ConversionTable()	;
			conversionTable.setConversionFactor(model.getConversionFactor());
			conversionTable.setCountryCode(model.getCountryCode());
			conversionRepository.save(conversionTable);
		}
			
	}


	public void updateConversionFactor(ConversionModel model) {
		// TODO Auto-generated method stub
		ConversionTable conversionTable = conversionRepository.findByCountryCode(model.getCountryCode());
		if(null != conversionTable)
		{
			conversionTable.setConversionFactor(model.getConversionFactor());
			conversionTable.setCountryCode(model.getCountryCode());
			conversionRepository.saveAndFlush(conversionTable);
		}
	}


	public void deleteConversionFactor(ConversionModel model) {
		// TODO Auto-generated method stub
		ConversionTable conversionTable = conversionRepository.findByCountryCode(model.getCountryCode());
		if(null != conversionTable)
		{
			conversionRepository.delete(conversionTable);
		}
	}

}
