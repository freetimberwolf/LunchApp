package controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import service.VotingService;
import service.impl.LuncherServiceImpl;

@CrossOrigin
@RestController
public class VotingController {
	
	@Autowired
	private VotingService votingService;
	
	@PostMapping(value="/voteForRestaurant/{restaurantId}/{luncherId}", produces=MediaType.APPLICATION_JSON_VALUE)	
	@ResponseBody
	public HttpStatus voteForRestaurant(@PathVariable Long restaurantId, @PathVariable Long luncherId) {
		return votingService.voteForRestaurant(restaurantId, luncherId);
	}
}
