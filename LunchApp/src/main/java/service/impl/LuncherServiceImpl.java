package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import entity.Luncher;
import repository.LuncherRepository;
import service.LuncherService;

@Service
public class LuncherServiceImpl implements LuncherService {

	@Autowired
	LuncherRepository luncherRepository;
	
	@Override
	public ResponseEntity<Luncher> saveLuncher(Luncher luncher) {
		try{
			return new ResponseEntity<>(luncherRepository.save(luncher), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
	}

	@Override
	public HttpStatus deleteLuncher(Luncher luncher) {
		try {
			luncherRepository.delete(luncher);
		}catch(Exception e) {
			return HttpStatus.BAD_REQUEST; 
		}
		return HttpStatus.OK;
	}

	@Override
	public ResponseEntity<Luncher> getLuncherById(long luncherId) {
		try {
			return new ResponseEntity<>(luncherRepository.findOne(luncherId),HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		}
	}

	
	@Override
	public ResponseEntity<List<Luncher>> findAll() {
		try{
			return new ResponseEntity<>(luncherRepository.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);						
		}
	}

	@Override
	public ResponseEntity<List<Luncher>> findActiveLunchers() {
		try{
			return new ResponseEntity<>(luncherRepository.findAllByGoing(true), HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);						
		}
	}
	
	@Override
	public HttpStatus addVoteToLuncher(long luncherId) {
		try{
			Luncher luncher = luncherRepository.findOne(luncherId);
			luncher.setVotes(luncher.getVotes()+1);
			luncherRepository.save(luncher);
		}catch(Exception e){
			return HttpStatus.BAD_REQUEST;						
		}
		return HttpStatus.OK;
	}
	
}
