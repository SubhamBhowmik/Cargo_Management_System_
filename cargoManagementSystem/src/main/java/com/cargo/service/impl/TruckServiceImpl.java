package com.cargo.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cargo.entity.Cargo;
import com.cargo.entity.Truck;
import com.cargo.exception.CargoNotExistException;
import com.cargo.repo.CargoRepository;
import com.cargo.repo.TruckRepository;

@Service
public class TruckServiceImpl {
	

	private TruckRepository truckRepo;
	private CargoRepository cargoRepo;
	
	@Autowired
	public TruckServiceImpl(TruckRepository truckRepo,CargoRepository cargoRepo) {
		//super();
		this.truckRepo = truckRepo;
		this.cargoRepo=cargoRepo;
	}


	//crud operations
	//savebook data
	//insert query is generated at runtime by server using hibernate and jpa
	public Truck saveTruck(int cargoId,Truck truck) throws CargoNotExistException
	{
		Cargo cargo = cargoRepo.findById(cargoId).orElse(null);
		if(cargo!=null)
        {
        truck.setCargo(cargo);
        return truckRepo.save(truck);
        }
        else
        {
        	throw new CargoNotExistException("Cargo is not existed");
        } 
	}
	

	public List<Truck> getAllTrucks()
	{
		
		List<Truck> trucks=truckRepo.findAll();
		//System.out.println(trucks);
		return trucks;
	}
	
	public 	Truck getTruckById(int id)
	{
		return truckRepo.findById(id).orElse(null);
	}

	public Truck updateTruck(int cargoId,int truckId, Truck truck)
	{
		Cargo cargo = cargoRepo.findById(cargoId).orElse(null);
		
		Truck existingtruck=truckRepo.findByCargoAndTruckid(cargo,truckId);
		
		if(existingtruck!=null)
		{
			existingtruck.setVehicleNo(truck.getVehicleNo());
			existingtruck.setCapacity(truck.getCapacity());
		return truckRepo.save(existingtruck);
		}
		return null;
	}
	
	public void deleteTruck(int id)
	{
		 truckRepo.deleteById(id);
	}
	
	public List<Truck> getTruckByCargoId(int cargoId) {
        Cargo cargo = cargoRepo.findById(cargoId).orElse(null);
        return truckRepo.findByCargo(cargo);
    }
	
}
