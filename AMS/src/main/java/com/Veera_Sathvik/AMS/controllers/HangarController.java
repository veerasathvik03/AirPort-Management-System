package com.Veera_Sathvik.AMS.controllers;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Veera_Sathvik.AMS.entities.Hangar;
import com.Veera_Sathvik.AMS.services.HangarService;

@RestController
@RequestMapping("/api/ams/v1/admin/hangars")
public class HangarController {
	Logger log = LoggerFactory.getLogger(HangarController.class);

	@Autowired
	private HangarService hangarService;

	//List of all Hangars
	@GetMapping("/hangar")
	ResponseEntity<List<Hangar>> getAllHangars(){
		log.info("List of all Hanagrs");
		List<Hangar> hangars =  hangarService.getHangars();
		return new ResponseEntity<List<Hangar>>(hangars,HttpStatus.OK);
	}

	//           //Get Hangar by ID
	//           @GetMapping("/hangar/{id}")
	//           ResponseEntity<Hangar> getHangarId(@PathVariable long id){
	//                          Hangar hangar =  hangarService.getHangar(id).get();
	//                          return new ResponseEntity<Hangar>(hangar,HttpStatus.OK);
	//           }

	//Adding Hangar to Database
	@PostMapping("/hangar")
	ResponseEntity<Hangar> addHangar(@RequestBody Hangar hangar){
		log.debug("Hangar Object" + hangar);
		hangarService.saveHangar(hangar);
		return new ResponseEntity<Hangar>(hangar,HttpStatus.CREATED);
	}

	//Get Hangar by ID
	@GetMapping("/hangar/{id}")
	public ResponseEntity<Hangar> getHangarById(@PathVariable long id) {
		Optional<Hangar> hangarOptional = hangarService.getHangar(id);
		if (hangarOptional.isPresent()) {
			Hangar hangar = hangarOptional.get();
			return new ResponseEntity<>(hangar, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Updating Hangar in Database
	@PutMapping("/hangar")
	public ResponseEntity<Hangar> updateHangar(@RequestBody Hangar hangar){
		Hangar h =  hangarService.saveHangar(hangar);
		return new ResponseEntity<Hangar>(h,HttpStatus.OK);
	}

	//Deleting Hangar
	@DeleteMapping("/hangar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteHangarById(@PathVariable long id) {
		Optional<Hangar> hangarOptional = hangarService.getHangar(id);
		if (hangarOptional.isPresent()) {
			hangarService.deleteHangar(id);
		}
	}
}


