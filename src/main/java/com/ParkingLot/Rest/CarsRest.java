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

import com.ParkingLot.Repo.CarsRepo;
import com.ParkingLot.entity.Cars;

@RestController
public class CarsRest {
	@Autowired
	private CarsRepo crepo;
	
	@GetMapping("/carslist")
	public List<Cars> c(){
		return crepo.findAll();
		
	}
	
	
	@PostMapping("/insert")
	public Cars add(@RequestBody Cars cars) {
		return crepo.save(cars);
		
		
	}
	 @PutMapping("/update/{carnum}/{cartype}")
	 public Cars addcar(@PathVariable("carnum") String num,@PathVariable("cartype") String cartype) {
		 var cars = crepo.findById(num);
		 if(cars.isPresent()) {
			 var v = cars.get();
			 v.setCartype(cartype);
			 crepo.save(v);
			 return v;
		 }
		 else
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"car is not found");
		 
		 
	 }
	 @DeleteMapping("/delete/{carnum}")
	 public String deletecar(@PathVariable("carnum") String num) {
		 var cars = crepo.findById(num);
		 if(cars.isPresent()) {
			 var r = cars.get();
			 crepo.delete(r);
			 return "deleted";
		 }
		 else
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND,"car is not found");
		 
	 }
	 
	 //1
	 @GetMapping("/carstype/{type}")
		public List<Cars> l(@PathVariable("type") String type){
			return crepo.findByCartype(type);
			
		}
	
		
	
	
	

}
