package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import entity.Luncher;
import entity.Restaurant;
import repository.RestaurantRepository;
import service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public ResponseEntity<Restaurant> saveRestaurant(Restaurant restaurant) {
		try{
			return new ResponseEntity<>(restaurantRepository.save(restaurant), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
	}
	
	@Override
	public HttpStatus deleteRestaurant(Restaurant restaurant) {
		try {
			restaurantRepository.delete(restaurant);
		}catch(Exception e) {
			return HttpStatus.BAD_REQUEST; 
		}
		return HttpStatus.OK;
	}
	
	@Override
	public ResponseEntity<Restaurant> getRestaurantById(long restaurantId) {
		try {
			return new ResponseEntity<>(restaurantRepository.findOne(restaurantId),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
	}
	
	@Override
	public ResponseEntity<List<Restaurant>> findAll() {
		try{
			return new ResponseEntity<>(restaurantRepository.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);						
		}
	}

	@Override
	public ResponseEntity<List<Restaurant>> findSuggestedRestaurants() {
		return null;
		//TODO: logic that suggests restaurants based on previous reviews and 
	}
	
	@Override
	public ResponseEntity<List<Restaurant>> findLeadingRestaurants(int qty) {
		try {
			Pageable topTwo = new PageRequest(0, qty);
			List<Restaurant> restaurants = restaurantRepository.findLeadingRestaurants(topTwo);
			return new ResponseEntity<>(restaurants,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
