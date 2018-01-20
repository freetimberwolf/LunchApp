package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Restaurant;
import service.RestaurantService;

@CrossOrigin
@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping(value="/saveRestaurant", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Restaurant> saveRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.saveRestaurant(restaurant);
	}
	
	@PostMapping(value="/deleteRestaurant", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpStatus deleteRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.deleteRestaurant(restaurant);
	}
	
	@GetMapping(value="/findAllRestaurants", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Restaurant>> findAllRestaurants() {
		return restaurantService.findAll();
	}
	
	@GetMapping(value="/findLeadingRestaurants/{qty}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Restaurant>> findLeadingRestaurants(@PathVariable int qty) {
		return restaurantService.findLeadingRestaurants(qty);
	}
	
	@GetMapping(value="/findSuggestedRestaurants", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Restaurant>> findSuggestedRestaurants() {
		return restaurantService.findSuggestedRestaurants();
	}
}
