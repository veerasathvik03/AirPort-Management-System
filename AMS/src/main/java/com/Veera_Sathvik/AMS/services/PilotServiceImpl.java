package com.Veera_Sathvik.AMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Veera_Sathvik.AMS.entities.Pilot;
import com.Veera_Sathvik.AMS.repositories.PilotRepository;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {

	@Autowired
	private PilotRepository pilotRepository;

	@Override
	public List<Pilot> getPilots() {
		return pilotRepository.findAll();
	}

	@Override
	public Pilot savePilot(Pilot pilot) {
		return pilotRepository.save(pilot);
	}

	@Override
	public Optional<Pilot> getPilot(long pid) {
		return pilotRepository.findById(pid);
	}

	@Override
	public void deletePilot(long pid) {
		pilotRepository.deleteById(pid);
	}

	@Override
	public List<Pilot> noPlanePilots() {
		return pilotRepository.noPlanePilots();
	}

	@Override
	public List<Object[]> allPilotPlane() {
		return pilotRepository.allPilotPlane();
	}

	@Override
	public List<Pilot> getPilots(long planeId) {
		return pilotRepository.getPilots(planeId);
	}
}

