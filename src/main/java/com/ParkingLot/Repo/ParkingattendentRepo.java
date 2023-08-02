package com.ParkingLot.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ParkingLot.entity.Parkingattendent;

public interface ParkingattendentRepo extends JpaRepository<Parkingattendent, Integer> {
	

	@Query(value = "SELECT * FROM parkingattendent WHERE entrydate=:a AND exitdate=:b", nativeQuery = true)
	List<Parkingattendent> getParkingAttendantsByEntryAndExitDates(@Param("a")LocalDate a,@Param("b") LocalDate b);

	@Query(value = "SELECT * FROM parkingattendent WHERE entrydate='6/23/23' and exitdate='6/25/23'", nativeQuery = true)
	List<Parkingattendent> getParkingAttendantsByEntryAndExitDate();
	
	
	
}
