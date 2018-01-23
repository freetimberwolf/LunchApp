package service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import entity.Luncher;

public interface LuncherService {

	public ResponseEntity<Luncher> saveLuncher(Luncher luncher);
	
	public HttpStatus deleteLuncher(Luncher luncher);
	
	public ResponseEntity<Luncher> getLuncherById(long luncherId);
	
	public ResponseEntity<List<Luncher>> findAll();
	
	public ResponseEntity<List<Luncher>> findActiveLunchers();
	
	/**
	 * Adds one vote to Luncher that is passed in. 
	 * @param luncher
	 * @return HttpStatus.OK for success, HttpStatus.BadRequest otherwise.
	 */
	public HttpStatus addVoteToLuncher(long luncherId);
	
}
