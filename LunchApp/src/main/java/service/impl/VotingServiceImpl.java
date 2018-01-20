package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import entity.Luncher;
import entity.Restaurant;
import repository.LuncherRepository;
import repository.RestaurantRepository;
import service.VotingService;

@Service
public class VotingServiceImpl implements VotingService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	LuncherRepository luncherRepository;

	@Override
	public HttpStatus voteForRestaurant(Long restaurantId, Long luncherId) {
		try{
			Luncher luncher = luncherRepository.findOne(luncherId);
			if(luncher.getVotes()>0) {
				Restaurant restaurant = restaurantRepository.findOne(restaurantId);
				restaurant.setTodaysVotes(restaurant.getTodaysVotes()+1);
				restaurant.setAllTimeVotes(restaurant.getAllTimeVotes()+1);
				restaurantRepository.save(restaurant);
				luncher.setVotes(luncher.getVotes()-1);
				luncherRepository.save(luncher);
				return  HttpStatus.OK;
			} else {
				return HttpStatus.EXPECTATION_FAILED;
			}
		}catch(Exception e){
			return HttpStatus.BAD_REQUEST;			
		}
	}
}
