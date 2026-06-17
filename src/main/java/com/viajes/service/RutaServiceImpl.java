package com.viajes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viajes.entity.Ruta;
import com.viajes.repository.RutaRepository;

@Service
public class RutaServiceImpl implements RutaService{

	@Autowired
	private RutaRepository repoRuta;
	
	@Override
	public List<Ruta> listar() {
		return repoRuta.findAll();
	}

	@Override
	public void registrarRuta(Ruta ruta) {
		repoRuta.save(ruta);
	}

	@Override
	public Ruta buscarPorId(int id) {
		return repoRuta.findById(id).orElse(null);
	}

	@Override
	public void actualizarRuta(Ruta ruta) {
		repoRuta.save(ruta);
	}

	@Override
	public void desactivarEstadoRuta(int id) {
		Ruta ruta = buscarPorId(id);
		if (ruta != null) {
			ruta.setEstado("INACTIVO");
			repoRuta.save(ruta);
		}
		
	}

}
