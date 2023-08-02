package com.ParkingLot.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="parkingslot")
public class ParkingSlot {
	
	@Id
	@Column(name="slotnum")
	private int slotnum;
	
	@Column(name="slotstatus")
	private String slotstatus;
	
	@Column(name="amount")
	private double amount;
	
	@OneToMany(mappedBy = "parkingslot")
	@JsonIgnore
	private List<Parkingattendent> parkingattendent  = new ArrayList<Parkingattendent>();
	

	public List<Parkingattendent> getParkingattendent() {
		return parkingattendent;
	}

	public void setParkingattendent(List<Parkingattendent> parkingattendent) {
		this.parkingattendent = parkingattendent;
	}

	public int getSlotnum() {
		return slotnum;
	}

	public void setSlotnum(int slotnum) {
		this.slotnum = slotnum;
	}

	public String getSlotstatus() {
		return slotstatus;
	}

	public void setSlotstatus(String slotstatus) {
		this.slotstatus = slotstatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
