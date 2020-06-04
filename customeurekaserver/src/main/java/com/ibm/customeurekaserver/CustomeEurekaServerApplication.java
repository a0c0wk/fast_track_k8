package com.ibm.customeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableAutoConfiguration
public class CustomeEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run (CustomeEurekaServerApplication.class, args);
    }

}
