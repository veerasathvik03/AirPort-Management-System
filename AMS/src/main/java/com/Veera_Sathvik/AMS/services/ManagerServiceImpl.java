package com.Veera_Sathvik.AMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Veera_Sathvik.AMS.entities.Manager;
import com.Veera_Sathvik.AMS.repositories.ManagerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	public List<Manager> NotApprovedManagers(){
		return managerRepository.notApprovedManagers();
	}

	@Override
	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}

	@Override
	public Optional<Manager> getManager(String managerId) {
		return managerRepository.findById(managerId);
	}

	@Override
	public void deleteManager(String managerId) {
		managerRepository.deleteById(managerId);
	}

	@Override
	public List<Manager> getManagers() {
		return managerRepository.findAll();
	}
}
