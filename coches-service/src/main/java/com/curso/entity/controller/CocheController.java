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

import com.curso.entity.Coche;
import com.curso.entity.service.CocheService;

@RestController
@RequestMapping("/coche")
public class CocheController {

	@Autowired
	private CocheService cocheService;
	
	@GetMapping()
	public ResponseEntity<List<Coche>> getAll(){
		List<Coche> coches = cocheService.getAll();
		if(coches.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(coches);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Coche> getCocheById(@PathVariable int id){
		Coche coche = cocheService.getCocheById(id);
		if(coche == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(coche);
	}
	
	@PostMapping()
	public ResponseEntity<Coche> save(@RequestBody Coche coche){
		Coche cocheBBDD = cocheService.save(coche);
		if(cocheBBDD == null)
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(cocheBBDD);
	}
	
	@GetMapping("/idUser/{idUser}")
	public ResponseEntity<List<Coche>> getAllCocheIdUser(@PathVariable int idUser){
		List<Coche> coches = cocheService.getAllCochesIdUser(idUser);
		if(coches.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(coches);
	}
	
	
}
