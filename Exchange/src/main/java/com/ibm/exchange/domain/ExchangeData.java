package com.ibm.exchange.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ExchangeData {
	
	private String countryCode;
	private Double conversionFactor;	
	private int qty;
	private Double convertedValue;

}
