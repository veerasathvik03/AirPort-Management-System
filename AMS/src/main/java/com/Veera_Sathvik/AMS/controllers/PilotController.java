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

import com.Veera_Sathvik.AMS.entities.Pilot;
import com.Veera_Sathvik.AMS.services.PilotService;

@RestController
@RequestMapping("/api/ams/v1/admin/pilots")
public class PilotController {
	Logger log = LoggerFactory.getLogger(PilotController.class);

	@Autowired
	private PilotService pilotService;

	//List of all Pilots
	@GetMapping("/pilot")
	ResponseEntity<List<Pilot>> getAllPilots(){
		log.info("Getting List of all Pilots");
		List<Pilot> pilots =  pilotService.getPilots();
		return new ResponseEntity<List<Pilot>>(pilots,HttpStatus.OK);
	}

	//Get Pilot by ID
	@GetMapping("/pilot/{id}")
	ResponseEntity<Pilot> getPilotId(@PathVariable long id){
		Optional<Pilot> pilotOptional = pilotService.getPilot(id);
		if (pilotOptional.isPresent()) {
			Pilot pilot = pilotOptional.get();
			return new ResponseEntity<>(pilot, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Adding Pilot to Database
	@PostMapping("/pilot")
	ResponseEntity<Pilot> addPilot(@RequestBody Pilot pilot){
		Pilot p =  pilotService.savePilot(pilot);
		return new ResponseEntity<Pilot>(p,HttpStatus.CREATED);
	}

	//Updating Pilot in Database
	@PutMapping("/pilot")
	ResponseEntity<Pilot> updatePilot(@RequestBody Pilot pilot){
		Pilot p =  pilotService.savePilot(pilot);
		return new ResponseEntity<Pilot>(p,HttpStatus.OK);
	}

	//Deleting Pilot
	@DeleteMapping("/pilot/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePilotById(@PathVariable long id) {
		Optional<Pilot> pilotOptional = pilotService.getPilot(id);
		if (pilotOptional.isPresent()) {
			pilotService.deletePilot(id);
		}
	}
}




