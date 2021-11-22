package com.curso.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.Repository.CocheRepository;
import com.curso.entity.Coche;

@Service
public class CocheService {

	@Autowired
	private CocheRepository cocheRepo;
	
	public List<Coche> getAll(){
		return cocheRepo.findAll();
	}
	
	public Coche getCocheById(int id) {
		return cocheRepo.findById(id).orElse(null);
	}
	
	public Coche save(Coche coche) {
		return cocheRepo.save(coche);
	}
	
	public List<Coche> getAllCochesIdUser(int idUser){
		return cocheRepo.findByIdUser(idUser);
	}
}
