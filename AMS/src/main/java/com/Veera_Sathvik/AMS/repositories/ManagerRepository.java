package com.Veera_Sathvik.AMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Veera_Sathvik.AMS.entities.Manager;

@Repository("managerRepository")
public interface ManagerRepository extends JpaRepository<Manager, String> {
	@Query(value="select * from managers where status ='Not_Approved'",nativeQuery=true)
	List<Manager> notApprovedManagers();
}
