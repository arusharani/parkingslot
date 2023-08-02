package com.ParkingLot.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="cars")
public class Cars {
	@Id
	@Column(name="carnum")
	private String carnum;
	
	@Column(name="cartype")
	private String cartype;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Parkingattendent> parkingattendent = new ArrayList<Parkingattendent>();

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public List<Parkingattendent> getParkingattendent() {
		return parkingattendent;
	}

	public void setParkingattendent(List<Parkingattendent> parkingattendent) {
		this.parkingattendent = parkingattendent;
	}
    
    
	
	

}
