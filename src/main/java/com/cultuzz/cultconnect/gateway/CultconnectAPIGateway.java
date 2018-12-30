package com.cultuzz.cultconnect.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CultconnectAPIGateway {

	public static void main(String[] args) {
		SpringApplication.run(CultconnectAPIGateway.class, args);
	}

}

