package com.ParkingLot.Rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ParkingLot.Repo.ParkingattendentRepo;
import com.ParkingLot.entity.Parkingattendent;

@RestController
public class Parkingattendent_Rest {
	@Autowired
	private ParkingattendentRepo parepo;

	@GetMapping("/parkinglist")
	public List<Parkingattendent> chhh() {
		return parepo.findAll();

	}

	@GetMapping("/getdatelist/{a}/{b}")
	public List<Parkingattendent> dates(@PathVariable("a") LocalDate a, @PathVariable("b") LocalDate b) {
		
		return parepo.getParkingAttendantsByEntryAndExitDates(a,b);

	}
	@GetMapping("/getdatelists")
	public List<Parkingattendent> dates() {
		
		return parepo.getParkingAttendantsByEntryAndExitDate();

	}
}
