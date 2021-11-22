package com.curso.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entity.Bike;
import com.curso.entity.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {

	@Autowired
	private BikeService bikeService;
	
	@GetMapping()
	public ResponseEntity<List<Bike>> getAll(){
		List<Bike> bikes = bikeService.getAll();
		if(bikes.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(bikes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bike> getCocheById(@PathVariable int id){
		Bike bike = bikeService.getCocheById(id);
		if(bike == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(bike);
	}
	
	@PostMapping()
	public ResponseEntity<Bike> save(@RequestBody Bike bike){
		Bike bikeBBDD = bikeService.save(bike);
		if(bikeBBDD == null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(bikeBBDD);
	}
	
	@GetMapping("/idUser/{idUser}")
	public ResponseEntity<List<Bike>> getAllCocheByIdUser(@PathVariable int idUser){
		List<Bike> bikes = bikeService.getAllUserByIdBike(idUser);
		if(bikes.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(bikes);
	}
	
	
}
