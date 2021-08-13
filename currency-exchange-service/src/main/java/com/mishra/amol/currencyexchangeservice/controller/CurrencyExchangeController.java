package com.mishra.amol.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mishra.amol.currencyexchangeservice.entity.ExchangeValue;
import com.mishra.amol.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;	
	
	@Autowired
	private ExchangeValueRepository repository;
	
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
//	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
//		ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(100));
//		exchangeValue.setPort(environment.getProperty("local.server.port"));
//		return exchangeValue;
//	}
	
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		if(exchangeValue == null) return new ExchangeValue();
		exchangeValue.setPort(environment.getProperty("local.server.port"));
		return exchangeValue;
	}

}
