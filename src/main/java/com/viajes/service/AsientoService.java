package com.viajes.service;

import java.util.List;
import com.viajes.entity.Asiento;

public interface AsientoService {
	List<Asiento> listar();
	List<Asiento> listarPorBus(int idBus);
	Asiento buscarPorId(int id);
}