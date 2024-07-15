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
@RequestMapping("/api/ams/v1/manager/assignment")
public class AllocationController {

	Logger log = LoggerFactory.getLogger(AllocationController.class);

	@Autowired
	private PilotPlaneService pilotPlaneService;

	@Autowired
	private PlaneHangarService planeHangarService;

	//Allocating Pilot to Plane
	@PostMapping("/pilotToplane")
	public ResponseEntity<String> allocate_pilot_to_plane(long pilotId,long planeId) {
		//pilotPlaneService.allocatePilotToPlane(pilotId, planeId);
		log.info("Allocated Pilot to Plane");
		return new ResponseEntity<String>
		(pilotPlaneService.allocatePilotToPlane(pilotId, planeId),HttpStatus.OK);
	}

	//Allocating Plane to Hanger
	@PostMapping("/planeTohangar")
	public ResponseEntity<String> allocate_plane_to_hangar(long planeId,long hangarId) {
		//planeHangarService.allocatehangarToPlane(hangarId, planeId);
		log.info("Allocated Plane to Hangar");
		return new ResponseEntity<String>
		(planeHangarService.allocatehangarToPlane(hangarId, planeId),HttpStatus.OK);
	}

}
