package com.Veera_Sathvik.AMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Veera_Sathvik.AMS.entities.Plane;

@Repository("planeRepository")
public interface PlaneRepository extends JpaRepository<Plane, Long>  {

	@Query(value = "select * from planes where hangar_id is null", nativeQuery = true)
	List<Plane> noHangarPlanes();

	@Query(value = "select plane_Id,hangar_id from planes where hangar_id is not null", nativeQuery = true)
	List<Object[]> allPlaneHangar();

	@Query( value = " select * from planes where hangar_id = ?", nativeQuery = true)
	List<Plane> getPlanes(long hangarId);
}