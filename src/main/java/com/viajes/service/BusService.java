package com.viajes.service;

import java.util.List;

import com.viajes.entity.Bus;

public interface BusService {
List<Bus>listar();
void registrar(Bus bus);
Bus buscarPorId(int id);
void actualizar(Bus bus);
void desactivar(int id);

}
