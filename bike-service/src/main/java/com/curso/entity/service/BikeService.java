package com.curso.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.Repository.BikeRepository;
import com.curso.entity.Bike;

@Service
public class BikeService {

	@Autowired
	private BikeRepository bikeRepo;
	
	public List<Bike> getAll(){
		return bikeRepo.findAll();
	}
	
	public Bike getCocheById(int id) {
		return bikeRepo.findById(id).orElse(null);
	}
	
	public Bike save(Bike bike) {
		return bikeRepo.save(bike);
	}
	
	public List<Bike> getAllUserByIdBike(int idUser){
		return bikeRepo.findByIdUser(idUser);
	}
}
