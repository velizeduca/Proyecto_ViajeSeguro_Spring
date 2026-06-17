package com.viajes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viajes.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
