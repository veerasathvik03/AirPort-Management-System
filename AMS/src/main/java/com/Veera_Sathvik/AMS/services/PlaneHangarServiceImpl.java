package com.Veera_Sathvik.AMS.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Veera_Sathvik.AMS.entities.Hangar;
import com.Veera_Sathvik.AMS.entities.Plane;
import com.Veera_Sathvik.AMS.repositories.HangarRepository;
import com.Veera_Sathvik.AMS.repositories.PlaneRepository;

@Service
@Transactional
public class PlaneHangarServiceImpl implements PlaneHangarService {

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private HangarRepository hangarRepository;
	public PlaneHangarServiceImpl() {}

	//Checking remaining Hangar capacity
	public int checkhangarCapacity(long hangarid) {
		Hangar h = hangarRepository.findById(hangarid).get();
		List<Plane> p = planeRepository.getPlanes(hangarid);
		return h.getCapacity()-p.size();
	}

	//Checking Planes with no Hangar
	public void planeStatus() {
		List<Plane> planes = planeRepository.noHangarPlanes();
		for(Plane p : planes)
			System.out.println(p);
	}

	//Checking remaining capacity of Hangars
	public List<String> hangarStatus() {
		List<Hangar> hangars = hangarRepository.findAll();
		List<String> status = new ArrayList<>();
		for(Hangar hangar : hangars) {
			status.add(hangar.getHangarId() + " has remaining capacity of " + (hangar.getCapacity()-planeRepository.getPlanes(hangar.getHangarId()).size()));
		}
		return status;
	}

	//Allocate Hangar to Plane
	public String allocatehangarToPlane(long hangarid, long planeid) {
		Hangar hangar = hangarRepository.findById(hangarid).get();
		Plane plane = planeRepository.findById(planeid).get();
		if (hangar != null && plane != null) {
			int avail_capacity = checkhangarCapacity(hangarid);
			if (avail_capacity > 0) {
				plane.setHangar(hangar);
				planeRepository.save(plane);
				return "Allocated hangar to Plane.....";
			}
			else {
				return "hangar is full.....";
			}
		}
		else
			return "Entered incorrect planeid or hangarid";
	}

	//Deallocate Hangar from Plane
	public String deallocatehangarFromPlane(long hangarid, long planeid) {
		Plane plane = planeRepository.findById(planeid).get();
		if(plane.getHangar().getHangarId() == hangarid) {
			plane.setHangar(null);
			planeRepository.save(plane);
			return "Deallocated Successfully.....";
		}
		else {
			return "This plane is not present in the specified hangar.....";
		}
	}

	//Get all Plane Hangar Allocations
	public List<String> getAllAllocations() {
		List<Object[]> allocations = planeRepository.allPlaneHangar();
		List<String> allallocations= new ArrayList<>();
		for(int i = 0;i<allocations.size();i++) {
			allallocations.add(allocations.get(i)[0] + "   " + allocations.get(i)[1]);
		}
		return allallocations;
	}
}