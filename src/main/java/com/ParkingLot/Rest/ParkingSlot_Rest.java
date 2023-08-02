package com.ParkingLot.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ParkingLot.Repo.ParkingSlotRepo;
import com.ParkingLot.entity.ParkingSlot;

@RestController
public class ParkingSlot_Rest {
	@Autowired
	private ParkingSlotRepo psrepo;

	
	@GetMapping("/slotlist")
	public List<ParkingSlot> c(){
		return psrepo.findAll();
		
	}
	
	@PostMapping("/insert1")
	public ParkingSlot add(@RequestBody ParkingSlot slot) {
		return psrepo.save(slot);
		
	}
	
	 @PutMapping("/update1/{slotnum}/{status}")
	 public ParkingSlot addcar(@PathVariable("slotnum") int num,@PathVariable("status") String a) {
		 var slot = psrepo.findById(num);
		 if(slot.isPresent()) {
			 var a1 = slot.get();
			 a1.setSlotstatus(a);
			 psrepo.save(a1);
			 return a1;
		 }
		 else
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"car is not found");
		 
		 
	 }
	 @DeleteMapping("/delete1/{slotnum}")
	 public String deletecar(@PathVariable("slotnum") int num) {
		 var cars = psrepo.findById(num);
		 if(cars.isPresent()) {
			 var r = cars.get();
			 psrepo.delete(r);
			 return "deleted";
		 }
		 else
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"car is not found");
		 
	 }
	 
	 @GetMapping("/slotlisttype/{status}")
	 
		public List<ParkingSlot> v(@PathVariable("status") String s){
			return psrepo.findByslotstatus(s);
			
		}
	 
	 
	 
	
}
