package com.ibm.conversion.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConversionModel {

    private String countryCode;
    private Double conversionFactor;
    private int port;
}
