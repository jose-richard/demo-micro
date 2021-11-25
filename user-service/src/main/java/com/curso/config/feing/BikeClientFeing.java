package com.curso.config.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.model.Bike;



@FeignClient(name = "bike-service")
@RequestMapping("/bike")
public interface BikeClientFeing {
	
	@PostMapping()
	public Bike save(@RequestBody Bike bike);

}
