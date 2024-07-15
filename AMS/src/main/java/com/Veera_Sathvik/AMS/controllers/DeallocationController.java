package com.Veera_Sathvik.AMS.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Veera_Sathvik.AMS.services.PilotPlaneService;
import com.Veera_Sathvik.AMS.services.PlaneHangarService;

@RestController

@RequestMapping("/api/ams/v1/manager/release")

public class DeallocationController {
	Logger log = LoggerFactory.getLogger(HangarController.class);

	@Autowired
	private PilotPlaneService pilotPlaneService;

	@Autowired
	private PlaneHangarService planeHangarService;

	//Deallocating Pilot from Plane
	@PostMapping("/pilotFromplane")
	public ResponseEntity<String> deallocate_pilot_from_plane(long pilotId,long planeId) {
		//pilotPlaneService.deallocatePilotToPlane(pilotId, planeId);
		log.info("Deallocated Pilot from Plane");
		return new ResponseEntity<String>
		(pilotPlaneService.deallocatePilotToPlane(pilotId, planeId),HttpStatus.OK);
	}

	//Deallocating Plane from Hangar
	@PostMapping("/planeFromhangar")
	public ResponseEntity<String> deallocate_plane_from_hangar(long planeId,long hangarId) {
		//planeHangarService.deallocatehangarFromPlane(hangarId, planeId);
		log.info("Deallocated Plane from Hangar");
		return new ResponseEntity<String>
		(planeHangarService.deallocatehangarFromPlane(hangarId, planeId),HttpStatus.OK);
	}
}



