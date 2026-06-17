package com.viajes.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.viajes.entity.Horario;
import com.viajes.repository.HorarioRepository;

@Service
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	private HorarioRepository repoHorario;
	@Override
	public List<Horario> listar() {
		return repoHorario.findAll();
	}

	@Override
	public void registrarHorario(Horario horario) {
		repoHorario.save(horario);
	}

	@Override
	public Horario buscarPorId(int id) {
		return repoHorario.findById(id).orElse(null);
	}

	@Override
	public void actualizarHorario(Horario horario) {
		repoHorario.save(horario);
	}

	@Override
	public void desactivarEstadoHorario(int id) {
		Horario horario = buscarPorId(id);
		if (horario != null) {
			horario.setEstado("INACTIVO");
			repoHorario.save(horario);
		}
	}

	@Override
	public List<Horario> buscarViajes(int origen, int destino, LocalDate fecha) {
				return repoHorario.buscarViajes(origen,destino,fecha);
	}
}