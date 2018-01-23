package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Luncher;
import entity.Restaurant;
import service.LuncherService;
import service.VotingService;
import service.impl.LuncherServiceImpl;

@CrossOrigin
@RestController
public class VotingController {
	
	@Autowired
	private VotingService votingService;
	
	@Autowired
	private LuncherService luncherService;
	
	@PostMapping(value="/voteForRestaurant", produces=MediaType.APPLICATION_JSON_VALUE)	
	@ResponseBody
	public HttpStatus voteForRestaurant(@Param("restaurantId") Long restaurantId, @Param("luncherId") Long luncherId) {
		return votingService.voteForRestaurant(restaurantId, luncherId);
	}
	
	@PostMapping(value="/addVoteToLuncher", consumes=MediaType.APPLICATION_JSON_VALUE)
	public HttpStatus voteForRestaurant(@Param("luncherId") long luncherId) {
		return luncherService.addVoteToLuncher(luncherId);
	}
	
}
