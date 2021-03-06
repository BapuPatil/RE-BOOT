package com.example.microservices.currencyconvsersionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//name = application.properties(currencyExchangeService) / spring.application.name
//@FeignClient(name="currency-exchange-service",url="http://localhost:8000/")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping(path="/currency-exchange-service/currency-exchange/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from")String from, 
			@PathVariable("to") String to);

	
}