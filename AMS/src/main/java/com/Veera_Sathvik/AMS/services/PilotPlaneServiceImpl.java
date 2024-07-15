package com.Veera_Sathvik.AMS.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Veera_Sathvik.AMS.entities.Pilot;
import com.Veera_Sathvik.AMS.entities.Plane;
import com.Veera_Sathvik.AMS.repositories.PilotRepository;
import com.Veera_Sathvik.AMS.repositories.PlaneRepository;

@Service
@Transactional
public class PilotPlaneServiceImpl implements PilotPlaneService {

	@Autowired
	private PlaneRepository planeRepository;

	@Autowired
	private PilotRepository pilotRepository;

	public PilotPlaneServiceImpl() {}

	//Checking remaining Plane Capacity
	public int checkPlaneCapcity(long planeID) {
		Plane p=planeRepository.findById(planeID).get();
		List<Pilot> pi=pilotRepository.getPilots(planeID);
		return p.getPlaneCapacity()-pi.size();
	}

	//Checking Pilots with no Planes
	public void pilotStatus() {
		List<Pilot> pilots = pilotRepository.noPlanePilots();
		for(Pilot p : pilots)
			System.out.println(p);
	}

	//Checking remaining Capacity of Planes
	public void planeStatus() {
		List<Plane>planes=planeRepository.findAll();
		for(Plane plane:planes) {
			List<Pilot>pi=pilotRepository.getPilots(plane.getPlaneId());
			System.out.println(plane.getPlaneId() + " has remaining capcity of " + (plane.getPlaneCapacity()-pi.size()));
		}
	}

	//Allocate Pilot to Plane

	public String allocatePilotToPlane(long pilotId,long planeId) {
		Pilot pilot = pilotRepository.findById(pilotId).get();
		Plane plane = planeRepository .findById(planeId).get();
		if (pilot != null && plane != null) {
			int avail_capcity=checkPlaneCapcity(planeId);
			if(avail_capcity>0) {
				pilot.setP(plane);
				pilotRepository.save(pilot);
				return "Allocated Pilot to Plane";
			}
			else {
				return "This plane has no space";
			}
		}

		else
			return "Entered incorrect planeid or pilotid";
	}

	//Deallocate Pilot from Plane
	public String deallocatePilotToPlane(long pilotId,long planeId) {
		Pilot pilot = pilotRepository.findById(pilotId).get();
		if(pilot.getP().getPlaneId() == planeId) {
			pilot.setP(null);
			pilotRepository.save(pilot);
			return "Deallocated Pilot to Plane";
		}
		else {
			return "This pilot is not present in the specified plane.....";
		}
	}

	//Get all Pilot Plane allocations
	public List<String> getAllAllocations() {
		List<Object[]> allocations =pilotRepository.allPilotPlane();
		List<String> allallocations=new ArrayList<>();
		for(int i = 0;i<allocations.size();i++) {
			allallocations.add(allocations.get(i)[0] + "   " + allocations.get(i)[1]);
		}
		return allallocations;
	}
}
