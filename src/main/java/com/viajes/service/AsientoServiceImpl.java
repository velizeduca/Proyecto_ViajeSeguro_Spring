package com.viajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.entity.Asiento;
import com.viajes.repository.AsientoRepository;

@Service
public class AsientoServiceImpl implements AsientoService {

	@Autowired
	private AsientoRepository repoAsiento;

	@Override
	public List<Asiento> listar() {
		return repoAsiento.findAll();
	}

	@Override
	public List<Asiento> listarPorBus(int idBus) {
		return repoAsiento.findByBus_IdBus(idBus);
	}

	@Override
	public Asiento buscarPorId(int id) {
		return repoAsiento.findById(id).orElse(null);
	}

}