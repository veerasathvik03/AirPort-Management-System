package com.Veera_Sathvik.AMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Veera_Sathvik.AMS.entities.Admin;

@Repository("adminRepository")
public interface AdminRepository extends JpaRepository<Admin, String> {

}

