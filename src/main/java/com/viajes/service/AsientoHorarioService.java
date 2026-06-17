package com.viajes.service;

import java.util.List;

import com.viajes.entity.AsientoHorario;

public interface AsientoHorarioService {

	List<AsientoHorario> listar();
	List<AsientoHorario> listarPorHorario(int idHorario);
	void registrar(AsientoHorario asientoHorario);
}