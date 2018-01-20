package repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	
//	@QueryHints({@QueryHint(name="TOP",value="3")})
//	public List<Restaurant> findLast3Restaurants();
//
//	public List<Restaurant> findTop3Restaurants();
	
	@Query("select R from Restaurant R order by R.todaysVotes desc")
	public List<Restaurant> findLeadingRestaurants(Pageable topTwo);
}
