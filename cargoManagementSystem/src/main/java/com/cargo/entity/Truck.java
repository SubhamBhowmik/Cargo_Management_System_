package com.cargo.entity;

import java.util.Set;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity

public class Truck {
	@Id  //for set  primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Integer truckid;
	private String vehicleNo;
	private Integer capacity;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "cargoid")
    private Cargo cargo;
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Truck() {
		// TODO Auto-generated constructor stub
	}

	
	public Integer getTruckid() {
		return truckid;
	}

	public void setTruckid(Integer truckid) {
		this.truckid = truckid;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Truck(Integer truckid, String vehicleNo, Integer capacity, Cargo cargo) {
		super();
		this.truckid = truckid;
		this.vehicleNo = vehicleNo;
		this.capacity = capacity;
		this.cargo = cargo;
	}

	
	
}
