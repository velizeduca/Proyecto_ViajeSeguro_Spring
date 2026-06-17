package com.viajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.entity.Bus;
import com.viajes.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService{

	@Autowired
private BusRepository repoBus;

	@Override
	public List<Bus> listar() {
		return repoBus.findAll();
	}

	@Override
	public void registrar(Bus bus) {
		repoBus.save(bus);
	}

	@Override
	public Bus buscarPorId(int id) {
		return repoBus.findById(id).orElse(null);
	}

	@Override
	public void actualizar(Bus bus) {
		repoBus.save(bus);
	}

	@Override
	public void desactivar(int id) {
		Bus bus = buscarPorId(id);
		if (bus != null) {
			bus.setEstado("INACTIVO");
			repoBus.save(bus);
		}
	}

}
