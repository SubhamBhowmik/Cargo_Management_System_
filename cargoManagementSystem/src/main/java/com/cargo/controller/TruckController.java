package com.cargo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cargo.entity.Truck;
import com.cargo.exception.CargoNotExistException;
import com.cargo.service.impl.CargoServiceImpl;
import com.cargo.service.impl.TruckServiceImpl;

@RestController
@RequestMapping("/trucks")
public class TruckController {

	private TruckServiceImpl truckService;
	private CargoServiceImpl cargoService;

	@Autowired
	public TruckController(TruckServiceImpl truckService, CargoServiceImpl cargoService) {
		// super();
		this.truckService = truckService;
		this.cargoService = cargoService;
	}
	// Basic URI for API Testing

	// http://localhost:8085/books

	@GetMapping("/cargo/{cargoId}")
	public List<Truck> getTruckByCargoId(@PathVariable int cargoId) {
		return truckService.getTruckByCargoId(cargoId);
	}

	// insert into book_entity(book_name, pub_date)values(?,?);
	// http://localhost:8085/books/insert
	@PostMapping("/insert/{cargoId}")
	public Truck saveTruck(@PathVariable int cargoId, @RequestBody Truck truck) throws CargoNotExistException {
		return truckService.saveTruck(cargoId, truck);
	}

	// select *from book_entity
	// http://localhost:8085/books/allbooks

	@GetMapping("/allTrucks")
	public List<Truck> getAllTrucks() {
		return truckService.getAllTrucks();

	}

	// select *from book_entity where isbnno=?
	// http://localhost:8085/books/1
	@GetMapping("/{id}")
	public Truck getTruckById(@PathVariable int id) {
		return truckService.getTruckById(id);
	}

	// http://localhost:8085/books/update/1
	@PutMapping("/update/{truckId}/{cargoId}")
	public Truck updateTruck(@PathVariable int truckId, @PathVariable int cargoId, @RequestBody Truck truck) {
		return truckService.updateTruck(cargoId, truckId, truck);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteTruck(@PathVariable int id) {
		truckService.deleteTruck(id);
	}

}
