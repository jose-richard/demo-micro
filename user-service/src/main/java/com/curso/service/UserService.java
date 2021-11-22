package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.config.feing.BikeClientFeing;
import com.curso.config.feing.CocheClientFeing;
import com.curso.entity.User;
import com.curso.model.Bike;
import com.curso.model.Coche;
import com.curso.repository.UserRepository;

@Service
public class UserService {
	
	private final String URL_COCHE = "http://localhost:9091/coche/idUser/";
	private final String URL_BIKE = "http://localhost:9092/bike/idUser/";
	
	@Autowired	
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CocheClientFeing cocheCienteFeing;
	
	@Autowired
	private BikeClientFeing bikeClientFeing;
	
	public List<User> getAll(){
		List<User> users =  userRepo.findAll();
		if(!users.isEmpty()) {
			//usanso Strems y Lambas
//			users = users.stream().map(user -> {
//				user.setBikes(getBikes(user.getId()));
//				user.setCoches(getCoches(user.getId()));
//				return user;
//			}).collect(Collectors.toList());
			//usanso Strems y Lambas foreach
			users.stream().forEach(user -> {
				user.setBikes(getBikes(user.getId()));
				user.setCoches(getCoches(user.getId()));
			});	
			
			//usando foreach
//			for(User user : users) {
//				user.setBikes(getBikes(user.getId()));
//     			user.setCoches(getCoches(user.getId()));
//			}
		}
		return users;
	}
	
	public User getUserById(int id){
		User user =userRepo.findById(id).orElse(null);
		if(user != null) {
			user.setBikes(getBikes(id));
			user.setCoches(getCoches(id));
		}
		return user;
			
	}
	
	public User save(User user) {
		return userRepo.save(user);
	}
	
	private List<Coche> getCoches(int id){		
		List<Coche> coches = restTemplate.getForObject(URL_COCHE + id, List.class);
		return coches;
	}	
	
	private List<Bike> getBikes(int id){
		List<Bike> bikes = restTemplate.getForObject(URL_BIKE + id, List.class);
		return bikes;
	}
	
	public Coche saveCoche(int idUser, Coche coche){
		coche.setIdUser(idUser);
		return cocheCienteFeing.save(coche);
	}
	
	public Bike saveBike(int idUser, Bike bike){
		bike.setIdUser(idUser);
		return bikeClientFeing.save(bike);
	}

}
