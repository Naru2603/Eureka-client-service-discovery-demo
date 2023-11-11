package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.model.Climate;

@Service
public class FetchClimateService {

	@Autowired
	RestTemplate restTemplate;

	public Climate fetch(String city)
	{
		
        // Use service discovery to locate the Climate Service

        String climateServiceUrl = "http://climate-api-demo/infy/climates/" + city;

        Climate climate = restTemplate.getForObject(climateServiceUrl, Climate.class);
        return climate;
	}
}
