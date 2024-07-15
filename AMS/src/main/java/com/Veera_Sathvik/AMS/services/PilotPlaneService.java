package com.Veera_Sathvik.AMS.services;

import java.util.List;

public interface PilotPlaneService {

	public int checkPlaneCapcity(long planeID);
	public void pilotStatus();
	public void planeStatus();
	public String allocatePilotToPlane(long pilotId,long planeId);
	public String deallocatePilotToPlane(long pilotId,long planeId);
	public List<String> getAllAllocations();

}