package com.curso.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.entity.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {
	
	public List<Bike> findByIdUser(int idUser);

}
