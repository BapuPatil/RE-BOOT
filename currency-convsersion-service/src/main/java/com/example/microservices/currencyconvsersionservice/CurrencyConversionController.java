package com.example.microservices.currencyconvsersionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchangeServiceProxy proxy;
	
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(path= "/currency-conversion-service/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean currencyConversion(
			@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity) {
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("from",from);
		map.put("to",to);
		String CurrencyExchange = "http://localhost:8000/currency-exchange/{from}/to/{to}";
		ResponseEntity<CurrencyConversionBean> responseEntity=
				new RestTemplate().getForEntity(CurrencyExchange, CurrencyConversionBean.class,map);
		
	CurrencyConversionBean response  = responseEntity.getBody();
	
		
		return new CurrencyConversionBean(response.getId(),from,to,quantity,response.conversionMultiple,
				quantity.multiply(response.getConversionMultiple()),response.getPort());
	}
		
	
	
	@GetMapping(path= "/currency-conversion-service-feign/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean currencyConversionfeign(
			@PathVariable String from, @PathVariable String to,@PathVariable BigDecimal quantity) {
		

		
	CurrencyConversionBean response  = proxy.retrieveExchangeValue(from, to);
	
	log.info("{}");
		
		return new CurrencyConversionBean(response.getId(),from,to,quantity,response.conversionMultiple,
				quantity.multiply(response.getConversionMultiple()),response.getPort());
	}
	
		
	}
