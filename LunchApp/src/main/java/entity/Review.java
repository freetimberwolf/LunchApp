package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="REVIEW")
public class Review {

	private long reviewId;
	private Restaurant restaurant;
	private double rating;
	private Luncher luncher;

	@Id
	@GeneratedValue
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	@JsonIgnoreProperties("reviews")
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")//join on owning side of relationship
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@JsonIgnoreProperties("reviewsPosted")
	@ManyToOne//source is Product....target is Vendor   so "many Products to one Vendor"
	@JoinColumn(name="LUNCHER_ID")//join on owning side of relationship
	public Luncher getLuncher() {
		return luncher;
	}
	public void setLuncher(Luncher luncher) {
		this.luncher = luncher;
	}

}
