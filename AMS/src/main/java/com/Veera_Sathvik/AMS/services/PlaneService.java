package com.Veera_Sathvik.AMS.services;

import java.util.List;
import java.util.Optional;

import com.Veera_Sathvik.AMS.entities.Plane;

public interface PlaneService {
         
public List<Plane> getPlanes();
         
              public Plane savePlane(Plane Plane);           
              public Optional<Plane> getPlane(long pid);           
              public void deletePlane(long pid);
              public List<Plane> noHangarPlanes();          
              public List<Object[]> allPlaneHangar();
              public List<Plane> getPlanes(long hangarId);
}
