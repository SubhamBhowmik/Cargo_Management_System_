package com.cargo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cargo.entity.Cargo;
import com.cargo.service.impl.CargoServiceImpl;

@Controller
public class CargoController {

	@Autowired
	private CargoServiceImpl cargoService;
	
	@RequestMapping("/")
	public String loadForm(Model model)
	{
		Cargo cargo=new Cargo();
		model.addAttribute("cargo", cargo);
		
		return "cargo";       // here driver is jsp file name
		                       // automatically add prefix and suffix
	}
	
	@RequestMapping("/insert")
	public String handleCargoForm(@ModelAttribute("cargo")Cargo cargo,Model model)
	{
		
		//intract to service layer
		boolean saveCargo = cargoService.saveCargo(cargo);
		
		String msg="";
		
		if(saveCargo)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "cargo";
	}
	
	
	@RequestMapping("/viewAll")
	public String viewAllCargo(Model model)
	{
		//fetch the data from the databse ,can interact service layer
		List<Cargo> allCargo = cargoService.getAllCargo();
		
		model.addAttribute("cargos", allCargo);
		return "viewCargo";
	}
	
	@RequestMapping("/deleteCargo")
	public String deleteCargo(@RequestParam("eid")     int id)
	{
		boolean flag = cargoService.deleteCargo(id);
		
		if(flag)
		return "redirect:/viewAll";
		else
		return "redirect:/viewAll";
	}
	
	
	@RequestMapping("/editCargo")
	public String editCargo(@RequestParam("eid")   int id,Model model)
	{
		Cargo cargo = cargoService.getCargoId(id);
		
		model.addAttribute("cargo", cargo);
		return "editCargo";
	}
	
	@RequestMapping("/update")
	public String updateCargo(Cargo cargo)
	{
		boolean updateBook = cargoService.updateCargo(cargo);
		
		return "redirect:/viewAll";

	}
	
	
	
	
	
}
