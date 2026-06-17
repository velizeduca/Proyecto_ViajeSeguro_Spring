package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.viajes.entity.Bus;
import com.viajes.entity.Horario;
import com.viajes.entity.Ruta;

import com.viajes.service.BusService;
import com.viajes.service.HorarioService;
import com.viajes.service.RutaService;

@Controller
@RequestMapping("/gestionhorario")
public class HorarioController {
	@Autowired
	private HorarioService horarioService;
	@Autowired
	private BusService busService;
	@Autowired
	private RutaService rutaService;

	// LISTAR HORARIOS
	
	@GetMapping("/lista")
	public String listar(Model model) {
		model.addAttribute("mensaje","Bienvenido al módulo de gestión de horarios");
		model.addAttribute("horarios",horarioService.listar());
		model.addAttribute("buses",busService.listar());
		model.addAttribute("rutas",rutaService.listar());
		// Objeto vacío para el formulario
		Horario horario = new Horario();
		horario.setBus(new Bus());
		horario.setRuta(new Ruta());
		model.addAttribute("horario",horario);
		return "horario/mantHorarios";
	}

	// REGISTRAR HORARIO
	@PostMapping("/registrar")
	public String registrar(Horario horario,RedirectAttributes redirect) {
		horarioService.registrarHorario(horario);
		redirect.addFlashAttribute("mensajeExito","Horario registrado correctamente");
		return "redirect:/gestionhorario/lista";
	}

	// BUSCAR POR ID
	@GetMapping("/buscar/{id}")
	@ResponseBody
	public Horario buscarPorId(@PathVariable int id) {
		return horarioService.buscarPorId(id);
	}

	// ACTUALIZAR HORARIO
	@PostMapping("/actualizar")
	public String actualizar(Horario horario,RedirectAttributes redirect) {
		horarioService.actualizarHorario(horario);
		redirect.addFlashAttribute("mensajeExito","Horario actualizado correctamente");
		return "redirect:/gestionhorario/lista";
	}

	// DESACTIVAR HORARIO
	@GetMapping("/desactivar/{id}")
	public String desactivar(@PathVariable int id,RedirectAttributes redirect) {
		horarioService.desactivarEstadoHorario(id);
		redirect.addFlashAttribute("mensajeExito","Horario desactivado correctamente");
		return "redirect:/gestionhorario/lista";
	}
}