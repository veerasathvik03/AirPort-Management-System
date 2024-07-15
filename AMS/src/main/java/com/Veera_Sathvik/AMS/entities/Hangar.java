package com.Veera_Sathvik.AMS.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.Table;



@SequenceGenerator(name = "hangar_gen", sequenceName = "hangar_gen",  initialValue = 101)
@Entity
@Table(name = "hangars")
public class Hangar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "hangar_gen")
	private long hangarId;
	private String hangarType;
	private String location;
	private int capacity;

	//           @OneToMany(fetch = FetchType.EAGER,mappedBy = "hangar")
	//           private List<Plane> planes;

	public long getHangarId() {
		return hangarId;
	}

	public Hangar() {
		super();
	}

	public Hangar(long hangarId, String hangarType, String location, int capacity) {
		super();
		this.hangarId = hangarId;
		this.hangarType = hangarType;
		this.location = location;
		this.capacity = capacity;
	}

	public void setHangarId(long hangarId) {
		this.hangarId = hangarId;
	}

	public String getHangarType() {
		return hangarType;
	}

	public void setHangarType(String hangarType) {
		this.hangarType = hangarType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	//           public List<Plane> getPlanes() {
	//                          return planes;
	//           }
	//
	//           public void setPlanes(List<Plane> planes) {
	//                          this.planes = planes;
	//           }

	@Override
	public String toString() {
		return "Hangar [hangarId=" + hangarId + ", hangarType=" + hangarType + ", location=" + location + ", capacity="
                                                          + capacity + "]";
	}
}

