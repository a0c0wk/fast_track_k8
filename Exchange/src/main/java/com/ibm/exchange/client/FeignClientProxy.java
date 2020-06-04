package com.ibm.exchange.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="conversion-service",url = "localhost:8081")
@FeignClient(name="conversion-service")
@RibbonClient(name="conversion-service")
public interface FeignClientProxy {
	
	@GetMapping("/conversion/factor/{country}")
    public Double getConversionFactor(@PathVariable("country") String country);

}
