package service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import entity.Restaurant;

public interface RestaurantService {

	ResponseEntity<Restaurant> saveRestaurant(Restaurant restaurant);

	HttpStatus deleteRestaurant(Restaurant restaurant);

	ResponseEntity<Restaurant> getRestaurantById(long restaurantId);

	ResponseEntity<List<Restaurant>> findAll();

	ResponseEntity<List<Restaurant>> findSuggestedRestaurants();

	ResponseEntity<List<Restaurant>> findLeadingRestaurants(int qty);

}
