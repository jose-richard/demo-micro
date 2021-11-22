package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.entity.User;
import com.curso.model.Bike;
import com.curso.model.Coche;
import com.curso.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;	
	
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		List<User> user = userService.getAll();
		if(user.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(user);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User user = userService.getUserById(id);
		if(user == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user){
		User userBBDD = userService.save(user);
		if(userBBDD == null)
			ResponseEntity.badRequest().build();		
		return ResponseEntity.ok(userBBDD);
	}
	
	@PostMapping("/saveCoche/{idUser}")
	public ResponseEntity<Coche> saveCoche(@RequestBody Coche coche, @PathVariable int idUser){
		Coche cocheBBDD = userService.saveCoche(idUser, coche);
		if(cocheBBDD == null)
			ResponseEntity.badRequest().build();		
		return ResponseEntity.ok(cocheBBDD);
	}
	
	@PostMapping("/saveBike/{idUser}")
	public ResponseEntity<Bike> saveCoche(@RequestBody Bike bike, @PathVariable int idUser){
		Bike bikeBBDD = userService.saveBike(idUser, bike);
		if(bikeBBDD == null)
			ResponseEntity.badRequest().build();		
		return ResponseEntity.ok(bikeBBDD);
	}

}
