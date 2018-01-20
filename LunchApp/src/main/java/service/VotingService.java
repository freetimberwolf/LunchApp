package service;

import org.springframework.http.HttpStatus;

import entity.Luncher;
import entity.Restaurant;

public interface VotingService {

	HttpStatus voteForRestaurant(Long restaurant, Long luncher);	
}
