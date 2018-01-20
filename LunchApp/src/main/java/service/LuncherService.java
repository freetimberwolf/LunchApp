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
	
}
