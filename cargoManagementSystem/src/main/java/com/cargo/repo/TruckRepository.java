package com.cargo.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cargo.entity.Cargo;
import com.cargo.entity.Truck;
@Repository
public interface TruckRepository extends JpaRepository<Truck, Integer> {

	List<Truck> findByCargo(Cargo cargo);
    Truck findByCargoAndTruckid(Cargo cargo, int id);

}
