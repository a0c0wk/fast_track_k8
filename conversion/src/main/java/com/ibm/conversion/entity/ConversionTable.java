package com.ibm.conversion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConversionTable {

    @Id
    private long id;
    private String countryCode;
    private Double conversionFactor;

    public ConversionTable() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public String toString() {
        return "ConversionFactor{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", conversionFactor=" + conversionFactor +
                '}';
    }
}
