package com.Veera_Sathvik.AMS.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Veera_Sathvik.AMS.entities.Pilot;
import com.Veera_Sathvik.AMS.entities.Plane;
import com.Veera_Sathvik.AMS.services.PilotPlaneService;
import com.Veera_Sathvik.AMS.services.PilotService;
import com.Veera_Sathvik.AMS.services.PlaneHangarService;
import com.Veera_Sathvik.AMS.services.PlaneService;

@RestController

@RequestMapping("/api/ams/v1/manager/")

public class CheckStatusController {

	Logger log = LoggerFactory.getLogger(HangarController.class);

	@Autowired
	private PilotPlaneService pilotPlaneService;

	@Autowired
	private PlaneHangarService planeHangarService;

	@Autowired
	private PlaneService planeService;

	@Autowired
	private PilotService pilotService;

	//List of Planes which are not allocated to Hangars
	@GetMapping("/planeStatus")
	ResponseEntity<List<Plane>> getNoHangarPlanes(){
		List<Plane> planes =  planeService.noHangarPlanes();
		return new ResponseEntity<List<Plane>>(planes,HttpStatus.OK);
	}

	//List of Pilots who are not allocated to Plane
	@GetMapping("/pilotStatus")
	ResponseEntity<List<Pilot>> getNoPlanePilots(){
		List<Pilot> pilots =  pilotService.noPlanePilots();
		return new ResponseEntity<List<Pilot>>(pilots,HttpStatus.OK);
	}

	//List of Hangars and their remaining space
	@GetMapping("/hangarStatus")
	ResponseEntity<List<String>> getFreeHangars(){
		List<String> status = planeHangarService.hangarStatus() ;
		return new ResponseEntity<List<String>>(status,HttpStatus.OK);
	}

	//List of Planes and their allocated Hangars
	@GetMapping("/allplanehangers")
	ResponseEntity<List<String>> getAllHangarplane(){
		List<String> allallocations =  planeHangarService.getAllAllocations();
		return new ResponseEntity<List<String>>(allallocations,HttpStatus.OK);
	}

	//List of Pilots and their allocated Planes
	@GetMapping("/allpilotplane")
	ResponseEntity<List<String>> getAllPilotPlanes(){
		List<String> allallocations =  pilotPlaneService.getAllAllocations();
		return new ResponseEntity<List<String>>(allallocations,HttpStatus.OK);
	}
}






