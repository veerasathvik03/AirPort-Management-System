package com.Veera_Sathvik.AMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Veera_Sathvik.AMS.entities.Plane;
import com.Veera_Sathvik.AMS.repositories.PlaneRepository;

@Service
@Transactional
public class PlaneServiceImpl implements PlaneService {

	@Autowired
	private PlaneRepository planeRepository;

	@Override
	public List<Plane> getPlanes() {
		return planeRepository.findAll();
	}

	@Override
	public Plane savePlane(Plane plane) {
		return planeRepository.save(plane);
	}

	@Override
	public Optional<Plane> getPlane(long pid) {
		return planeRepository.findById(pid);
	}

	@Override
	public void deletePlane(long pid) {
		planeRepository.deleteById(pid);
	}

	@Override
	public List<Plane> noHangarPlanes() {
		return planeRepository.noHangarPlanes();
	}

	@Override
	public List<Object[]> allPlaneHangar() {
		return planeRepository.allPlaneHangar();
	}

	@Override
	public List<Plane> getPlanes(long hangarId) {
		return planeRepository.getPlanes(hangarId);
	}
}
