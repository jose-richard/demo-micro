package com.curso.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.entity.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {

	public List<Coche> findByIdUser(int idUser);
}
