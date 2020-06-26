package com.example.microservices.currencyconvsersionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients("com.example.microservices.currencyconvsersionservice")
@EnableDiscoveryClient
public class CurrencyConvsersionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvsersionServiceApplication.class, args);
	}

	
	@Bean
	public Sampler defaultSamp() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
