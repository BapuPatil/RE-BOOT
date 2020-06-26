package com.example.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment environment;
	 	
	@Autowired
	ExchangeValueRepository repo;
	
	@GetMapping(path="/currency-exchange/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, 
			@PathVariable String to) {
		
				int port = Integer.parseInt(
						environment.getProperty("local.server.port"));
				
			ExchangeValue exchangeValue = 
					repo.findByFromAndTo(from, to);
//					new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65));
		
			log.info("{}");
			
			exchangeValue.setPort(port);
			
		return exchangeValue ;
	}
	
}
