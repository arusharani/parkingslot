package com.ParkingLot.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="parkingattendent")
public class Parkingattendent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sno")
	private int sno;
	
	@Column(name="carnum")
	private String carnum;
	
	@Column(name="slotnum")
	private int slotnum;
	
	@Column(name="entrydate")
	private Date entrydate;
	
	@Column(name="exitdate")
	private Date exitdate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "carnum", updatable = false,insertable= false)
	@JsonIgnore
	private Cars car;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "slotnum", updatable= false,insertable=false)
	@JsonIgnore
	private ParkingSlot parkingslot;
	
	

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public int getSlotnum() {
		return slotnum;
	}

	public void setSlotnum(int slotnum) {
		this.slotnum = slotnum;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public Date getExitdate() {
		return exitdate;
	}

	public void setExitdate(Date exitdate) {
		this.exitdate = exitdate;
	}

	public Cars getCar() {
		return car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	public ParkingSlot getParkingslot() {
		return parkingslot;
	}

	public void setParkingslot(ParkingSlot parkingslot) {
		this.parkingslot = parkingslot;
	}


	
	
	
	
	

}
