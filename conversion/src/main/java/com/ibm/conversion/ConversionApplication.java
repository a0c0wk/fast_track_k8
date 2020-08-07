package com.ibm.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableSwagger2
@ComponentScan("com.ibm.conversion")
public class ConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run (ConversionApplication.class, args);
    }

}
