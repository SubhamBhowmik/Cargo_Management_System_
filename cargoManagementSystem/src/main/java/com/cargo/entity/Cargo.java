package com.cargo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cargo {
	@Id  //for set  primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Integer cargoid;
	private String name;
	private Integer contactNo;
	private String email;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private Set<Truck> truck = new HashSet<>();
	
	
}
