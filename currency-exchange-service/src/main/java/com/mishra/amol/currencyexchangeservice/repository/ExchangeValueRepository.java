package com.mishra.amol.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mishra.amol.currencyexchangeservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);

}
