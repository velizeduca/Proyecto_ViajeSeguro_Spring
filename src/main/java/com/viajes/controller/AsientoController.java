package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.viajes.entity.Horario;
import com.viajes.service.AsientoService;
import com.viajes.service.HorarioService;

@Controller
public class AsientoController {

	@Autowired
	private HorarioService horarioService;
	@Autowired
	private AsientoService asientoService;

	@GetMapping("/seleccionar-asientos/{idHorario}")
	public String seleccionarAsientos(@PathVariable int idHorario,Model model) {
		Horario horario =horarioService.buscarPorId(idHorario);
		model.addAttribute("horario", horario);
		model.addAttribute("asientos",asientoService.listarPorBus(horario.getBus().getIdBus()));
		return "asiento/seleccionarAsientos";
	}
}