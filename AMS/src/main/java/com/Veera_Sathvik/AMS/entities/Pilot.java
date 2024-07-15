package com.Veera_Sathvik.AMS.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.Table;
 
@SequenceGenerator(name = "pilot_gen", sequenceName = "pilot_gen",  initialValue = 1001)
@Entity
@Table(name="pilots")
public class Pilot {

              @Id
              @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pilot_gen")
              private long pilotid;
              private String name;
              private String position;
              private long licensenumber;
              private String aircraftType;

              @OneToOne
              @JoinColumn(name = "plane_id")
              private Plane p;

              public Pilot() {
                             super();
              }

              public Pilot(long pilotid, String name, String position, long licensenumber, String aircraftType, Plane p) {
                             super();
                             this.pilotid = pilotid;
                             this.name = name;
                             this.position = position;
                             this.licensenumber = licensenumber;
                             this.aircraftType = aircraftType;
                             this.p = p;
              }

              public long getPilotid() {
                             return pilotid;
              }

              public void setPilotid(long pilotid) {
                             this.pilotid = pilotid;
              }
 
              public String getName() {
                             return name;
              }

              public void setName(String name) {
                            this.name = name;
              }

              public String getPosition() {
                             return position;
              }

              public void setPosition(String position) {
                             this.position = position;
              }

              public long getLicensenumber() {
                             return licensenumber;
              }

              public void setLicense_number(long licensenumber) {
                             this.licensenumber = licensenumber;
              }

              public String getAircraftType() {
                             return aircraftType;
              }

              public void setAircraftType(String aircraftType) {
                             this.aircraftType = aircraftType;
              }

              public Plane getP() {
                             return p;
              }

              public void setP(Plane p) {
                             this.p = p;
              }


              @Override
              public String toString() {
                             return "Pilot [pilotid=" + pilotid + ", name=" + name + ", position=" + position + ", licensenumber="
                                                          + licensenumber + ", aircraftType=" + aircraftType + "]";
              }
}

 

 


