package com.Veera_Sathvik.AMS.controllers;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Veera_Sathvik.AMS.entities.Manager;
import com.Veera_Sathvik.AMS.services.ManagerService;

@RestController
@RequestMapping("/api/ams/v1/admin/managers")
public class AdminController {
	Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private ManagerService managerService;

	//List of Managers
	@GetMapping("/Manager")
	ResponseEntity<List<Manager>> getAllManagers(){
		log.info("List of Managers");
		List<Manager> managers =  managerService.getManagers();
		return new ResponseEntity<List<Manager>>(managers,HttpStatus.OK);
	}

	//List of Not Approved Managers
	@GetMapping("/NotApprovedManagers")
	ResponseEntity<List<Manager>> getAllNotApprovedManagers(){
		log.info("List of Not Approved Managers");
		List<Manager> managers =  managerService.NotApprovedManagers();
		return new ResponseEntity<List<Manager>>(managers,HttpStatus.OK);
	}

	//Approving the Manager by Admin
	@PutMapping("/approveManager")
	public ResponseEntity<Manager> updateManager(String ManagerId){
		Manager m=managerService.getManager(ManagerId).get();
		m.setStatus("Approved");
		Manager managers =  managerService.saveManager(m);
		return new ResponseEntity<Manager>(managers,HttpStatus.OK);
	}

}
