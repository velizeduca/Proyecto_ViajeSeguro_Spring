package com.viajes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.viajes.entity.AsientoHorario;

public interface AsientoHorarioRepository extends JpaRepository<AsientoHorario, Integer>{
	List<AsientoHorario> findByHorario_IdHorario(int idHorario);
}