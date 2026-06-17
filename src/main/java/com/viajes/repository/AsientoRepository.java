package com.viajes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.viajes.entity.Asiento;
public interface AsientoRepository extends JpaRepository<Asiento, Integer>{
	List<Asiento> findByBus_IdBus(int idBus);

}