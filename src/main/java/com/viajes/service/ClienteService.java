package com.viajes.service;

import java.util.List;

import com.viajes.entity.Cliente;

public interface ClienteService {
	List<Cliente> listar();
	void registrarCliente(Cliente cliente);
	Cliente buscarPorId(int id);
	void actualizarCliente(Cliente cliente);
	void desactivarEstadoCliente(int id);

}