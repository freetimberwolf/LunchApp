package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="RESTAURANT")
public class Restaurant {
	//Id
		private long restaurantId;
		private String name;
		private Address address;
		
		//Reviews and Functioning
		private List<Review> reviews;
		private double averageRating;
		private int allTimeVotes;
		private int amountOfWins;
		private int todaysVotes;
		private double distance;
		private boolean activated;
		
		@Id
		@GeneratedValue
		public long getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(long restaurantId) {
			this.restaurantId = restaurantId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		@JsonIgnoreProperties("restaurant")
		@OneToMany(cascade=CascadeType.ALL, mappedBy="luncher") 	
		public List<Review> getReviews() {
			return reviews;
		}
		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}
		public double getAverageRating() {
			return averageRating;
		}
		public void setAverageRating(double averageRating) {
			this.averageRating = averageRating;
		}
		public int getAllTimeVotes() {
			return allTimeVotes;
		}
		public void setAllTimeVotes(int allTimeVotes) {
			this.allTimeVotes = allTimeVotes;
		}
		public int getAmountOfWins() {
			return amountOfWins;
		}
		public void setAmountOfWins(int amountOfWins) {
			this.amountOfWins = amountOfWins;
		}
		public int getTodaysVotes() {
			return todaysVotes;
		}
		public void setTodaysVotes(int todaysVotes) {
			this.todaysVotes = todaysVotes;
		}
		public double getDistance() {
			return distance;
		}
		public void setDistance(double distance) {
			this.distance = distance;
		}
		public boolean isActivated() {
			return activated;
		}
		public void setActivated(boolean activated) {
			this.activated = activated;
		}

}
