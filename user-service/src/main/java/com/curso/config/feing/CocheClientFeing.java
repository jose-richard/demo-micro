package com.curso.config.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.model.Coche;



@FeignClient(name = "coches-service", url = "http://localhost:9091")
@RequestMapping("/coche")
public interface CocheClientFeing {
	
	@PostMapping()
	public Coche save(@RequestBody Coche coche);

}
