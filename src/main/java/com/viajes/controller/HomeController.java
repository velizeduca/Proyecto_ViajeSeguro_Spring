package com.viajes.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.viajes.service.CiudadService;
import com.viajes.service.HorarioService;

@Controller
public class HomeController {
	@Autowired
	private CiudadService ciudadService;
	

	@Autowired
	private HorarioService horarioService;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("ciudades",ciudadService.listar());
		return "index";
	}
	
	
	// ==================================================
		// BUSCAR VIAJES
		// ==================================================

		@GetMapping("/buscar")
		public String buscarViajes(
				@RequestParam int origen,
				@RequestParam int destino,
				@RequestParam LocalDate fecha,
				Model model) {
			model.addAttribute("ciudades",ciudadService.listar());
			model.addAttribute("horarios",horarioService.buscarViajes(origen,destino,fecha));
			model.addAttribute("origenSeleccionado",origen);
			model.addAttribute("destinoSeleccionado",destino);
			model.addAttribute("fechaSeleccionada",fecha);
			return "index";
		}
	
	
	
	
}