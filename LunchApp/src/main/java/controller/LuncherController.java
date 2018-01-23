package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Luncher;
import service.impl.LuncherServiceImpl;

import org.springframework.http.HttpStatus;

@CrossOrigin
@RestController
public class LuncherController {
	@Autowired
	private LuncherServiceImpl luncherServiceImpl;
	
	@PostMapping(value="/saveLuncher", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Luncher> saveLuncher(@RequestBody Luncher luncher) {
		return luncherServiceImpl.saveLuncher(luncher);
	}

	@PostMapping(value="/deleteLuncher", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HttpStatus deleteLuncher(@RequestBody Luncher luncher) {
		return luncherServiceImpl.deleteLuncher(luncher);
	}
	
	@GetMapping(value="/getLuncherById", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Luncher> getActiveLunchers(@Param("luncherId") long luncherId) {
		return luncherServiceImpl.getLuncherById(luncherId);
	}
	
	@GetMapping(value="/getAllLunchers",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Luncher>> getAllLunchers(){
		return luncherServiceImpl.findAll();
	}

	@GetMapping(value="/getActiveLunchers", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Luncher>> getActiveLunchers() {
		return luncherServiceImpl.findActiveLunchers();
	}

}
