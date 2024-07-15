package com.Veera_Sathvik.AMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Veera_Sathvik.AMS.entities.Pilot;

@Repository("pilotRepository")
public interface PilotRepository extends JpaRepository<Pilot, Long> {

              @Query(value = "select * from pilots where plane_id is null", nativeQuery = true)
              List<Pilot> noPlanePilots();

              @Query(value = "select pilotId,plane_id from pilots where plane_id is not null", nativeQuery = true)
              List<Object[]> allPilotPlane();

              @Query( value = " select * from pilots where plane_id = ?", nativeQuery = true)
              List<Pilot> getPilots(long planeId);
}
