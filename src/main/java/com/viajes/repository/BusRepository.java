package com.viajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.viajes.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{

}
