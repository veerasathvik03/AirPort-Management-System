package com.Veera_Sathvik.AMS.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.SequenceGenerator;

import jakarta.persistence.Table;

@SequenceGenerator(name = "plane_gen", sequenceName = "plane_gen",  initialValue = 10001)
@Entity
@Table(name = "planes")
public class Plane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "plane_gen")
	private long planeId;
	private String planeName;
	private String planeType;
	private int planeCapacity;
	private int registerednum;

	@ManyToOne
	@JoinColumn(name = "hangar_id")
	private Hangar hangar;

	//    @OneToMany(mappedBy = "p")
	//    private List<Pilot> pilots;

	public Plane() {
		super();
	}
	
	public Plane(long planeId, String planeName, String planeType, int planeCapacity, int registerednum,
			Hangar hangar) {
		super();
		this.planeId = planeId;
		this.planeName = planeName;
		this.planeType = planeType;
		this.planeCapacity = planeCapacity;
		this.registerednum = registerednum;
		this.hangar = hangar;
	}

	public long getPlaneId() {
		return planeId;
	}
	
	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}

	public int getPlaneCapacity() {
		return planeCapacity;
	}

	public void setPlaneCapacity(int planeCapacity) {
		this.planeCapacity = planeCapacity;
	}

	public int getRegisterednum() {
		return registerednum;
	}

	public void setRegisterednum(int registerednum) {
		this.registerednum = registerednum;
	}

	public Hangar getHangar() {
		return hangar;
	}

	public void setHangar(Hangar hangar) {
		this.hangar = hangar;
	}

	//           public List<Pilot> getPilots() {
	//                          return pilots;
	//           }
	//           public void setPilots(List<Pilot> pilots) {
	//                          this.pilots = pilots;
	//           }

	@Override
	public String toString() {
		return "Plane [planeId=" + planeId + ", planeName=" + planeName + ", planeType=" + planeType
				+ ", planeCapacity=" + planeCapacity + ", registerednum=" + registerednum + "]";
	}
}




