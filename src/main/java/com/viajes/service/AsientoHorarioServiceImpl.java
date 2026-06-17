package com.viajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.entity.AsientoHorario;
import com.viajes.repository.AsientoHorarioRepository;

@Service
public class AsientoHorarioServiceImpl
implements AsientoHorarioService {

	@Autowired
	private AsientoHorarioRepository repoAsientoHorario;

	@Override
	public List<AsientoHorario> listar() {
		return repoAsientoHorario.findAll();
	}

	@Override
	public List<AsientoHorario> listarPorHorario(int idHorario) {
		return repoAsientoHorario.findByHorario_IdHorario(idHorario);
	}

	@Override
	public void registrar(AsientoHorario asientoHorario) {
		repoAsientoHorario.save(asientoHorario);
	}

}