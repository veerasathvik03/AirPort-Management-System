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

import com.Veera_Sathvik.AMS.entities.Plane;
import com.Veera_Sathvik.AMS.services.PlaneService;

@RestController
@RequestMapping("/api/ams/v1/admin/planes")
public class PlaneController {
	Logger log = LoggerFactory.getLogger(PlaneController.class);

	@Autowired
	private PlaneService planeService;

	//List of all Planes
	@GetMapping("/plane")
	ResponseEntity<List<Plane>> getAllPlanes(){
		log.info("Reading all Customers");
		List<Plane> planes =  planeService.getPlanes();
		return new ResponseEntity<List<Plane>>(planes,HttpStatus.OK);
	}

	//Get Plane by ID
	@GetMapping("/plane/{id}")
	public ResponseEntity<Plane> getHangarById(@PathVariable long id) {
		Optional<Plane> planeOptional = planeService.getPlane(id);
		if (planeOptional.isPresent()) {
			Plane plane = planeOptional.get();
			return new ResponseEntity<>(plane, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Adding Plane to Database
	@PostMapping("/plane")
	ResponseEntity<Plane> addPlane(@RequestBody Plane plane){
		Plane p =  planeService.savePlane(plane);
		return new ResponseEntity<Plane>(p,HttpStatus.CREATED);
	}

	//Updating Plane in Database
	@PutMapping("/plane")
	ResponseEntity<Plane> updatePlane(@RequestBody Plane plane){
		Plane p =  planeService.savePlane(plane);
		return new ResponseEntity<Plane>(p,HttpStatus.OK);
	}

	//Delete Plane by ID
	@DeleteMapping("/plane/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlaneById(@PathVariable long id) {
		Optional<Plane> planeOptional = planeService.getPlane(id);
		if (planeOptional.isPresent()) {
			planeService.deletePlane(id);
		}
	}
}




