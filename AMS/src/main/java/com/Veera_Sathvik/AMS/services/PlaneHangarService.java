package com.Veera_Sathvik.AMS.services;

import java.util.List;

public interface PlaneHangarService {

	public int checkhangarCapacity(long hangarid);
	public void planeStatus();
	public List<String> hangarStatus();
	public String allocatehangarToPlane(long hangarid, long planeid);
	public String deallocatehangarFromPlane(long hangarid, long planeid);
	public List<String> getAllAllocations();

}
