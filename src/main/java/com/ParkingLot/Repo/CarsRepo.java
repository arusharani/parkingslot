package com.ParkingLot.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ParkingLot.entity.Cars;

public interface CarsRepo extends JpaRepository<Cars,String>{

	List<Cars> findByCartype(String cartype);
}
