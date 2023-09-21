package com.cargo.service;

import java.util.List;

import com.cargo.entity.Cargo;


public interface CargoService {
             //CRUD OPERATIONS 
	public boolean saveCargo(Cargo cargo);//for insert
	
	public List<Cargo> getAllCargo();  //get all rows
	
	public Cargo getCargoId(int id);  // get single rows

	public boolean updateCargo(Cargo cargo);  //for update

	public boolean deleteCargo(int id);    //delete
	



	
	
	
}


