package com.ParkingLot.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParkingLot.entity.ParkingSlot;

public interface ParkingSlotRepo extends JpaRepository<ParkingSlot, Integer> {

	
	List<ParkingSlot> findByslotstatus(String slotstatus); 
	
}
