package com.Veera_Sathvik.AMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Veera_Sathvik.AMS.entities.Hangar;
import com.Veera_Sathvik.AMS.repositories.HangarRepository;

@Service
@Transactional
public class HangarServiceImpl implements HangarService {

	@Autowired
	private HangarRepository hangarRepository;

	@Override
	public List<Hangar> getHangars() {
		return hangarRepository.findAll();
	}

	@Override
	public Hangar saveHangar(Hangar hangar) {
		hangarRepository.save(hangar);
		return hangar;
	}

	@Override
	public Optional<Hangar> getHangar(long hid)  {
		return hangarRepository.findById(hid);
	}

	@Override
	public void deleteHangar(long hid)  {
		hangarRepository.deleteById(hid);
	}
}
