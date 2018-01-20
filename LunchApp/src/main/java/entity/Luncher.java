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
@Table(name="LUNCHER")
public class Luncher {

	private long luncherId;
	private String username;
	private String password;
	
	private int qtyReviewsPosted;
	private List<Review> reviewsPosted;
	
	private int votes;
	private boolean isGoing;
	
	@Id
	@GeneratedValue
	public long getLuncherId() {
		return luncherId;
	}
	public void setLuncherId(long luncherId) {
		this.luncherId = luncherId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String firstName) {
		this.username = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String lastName) {
		this.password = lastName;
	}
	public int getQtyReviewsMade() {
		return qtyReviewsPosted;
	}
	public void setQtyReviewsMade(int qtyReviewsPosted) {
		this.qtyReviewsPosted = qtyReviewsPosted;
	}
	
	@JsonIgnoreProperties("lunchers")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="luncher") 	
	public List<Review> getReviewsPosted() {
		return reviewsPosted;
	}
	public void setReviewsPosted(List<Review> reviewsPosted) {
		this.reviewsPosted = reviewsPosted;
	}
	public int getQtyReviewsPosted() {
		return qtyReviewsPosted;
	}
	public void setQtyReviewsPosted(int qtyReviewsPosted) {
		this.qtyReviewsPosted = qtyReviewsPosted;
	}
	public boolean isGoing() {
		return isGoing;
	}
	public void setGoing(boolean isGoing) {
		this.isGoing = isGoing;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

}
