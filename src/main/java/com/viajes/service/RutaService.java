package com.viajes.service;

import java.util.List;

import com.viajes.entity.Ruta;

public interface RutaService {
	List<Ruta> listar();
	void registrarRuta(Ruta ruta);
	Ruta buscarPorId(int id);
	void actualizarRuta(Ruta ruta);
	void desactivarEstadoRuta(int id);

}