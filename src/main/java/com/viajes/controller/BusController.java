package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.ResponseBody;


import com.viajes.entity.Bus;
import com.viajes.entity.MarcaBus;
import com.viajes.service.BusService;
import com.viajes.service.MarcaBusService;

@Controller
@RequestMapping("/gestionbus")
public class BusController {
	// ==================================================
	// INYECCIÓN DE DEPENDENCIAS
	// ==================================================
	@Autowired
	private BusService busService;
	@Autowired
	private MarcaBusService marcaBusService;
	// ==================================================
	// LISTAR BUSES
	// ==================================================
	@GetMapping("/lista")
	public String listar(Model model) {
		// Mensaje informativo
		model.addAttribute("mensaje","Bienvenido al módulo de gestión de buses");
		// Lista de buses
		model.addAttribute("buses",busService.listar());
		// Lista de marcas para el ComboBox
		model.addAttribute("marcas",marcaBusService.listar());
		// Objeto vacío para registrar
		Bus bus = new Bus();
		bus.setMarcaBus(new MarcaBus());
		model.addAttribute("bus", bus);
		//retornando la pagina
		return "bus/mantBuses";
	}

	// ==================================================
	// REGISTRAR BUS
	// ==================================================
	@PostMapping("/registrar")
	public String registrar(Bus bus, RedirectAttributes redirect) {
		busService.registrar(bus);
		redirect.addFlashAttribute("mensajeExito","Bus registrado correctamente");
		return "redirect:/gestionbus/lista";
	}
	// ==================================================
	// BUSCAR BUS POR ID
	// (se utilizará para editar)
	// ==================================================
	@GetMapping("/buscar/{id}")
	@ResponseBody
	
	public Bus buscarPorId(@PathVariable int id) {
		return busService.buscarPorId(id);
	}

	// ==================================================
	// ACTUALIZAR BUS
	// ==================================================
	@PostMapping("/actualizar")
	public String actualizar(Bus bus,RedirectAttributes redirect) {
		busService.actualizar(bus);
		redirect.addFlashAttribute("mensajeExito","Bus actualizado correctamente");
		return "redirect:/gestionbus/lista";
	}
	// ==================================================
	// ELIMINAR LÓGICAMENTE
	// CAMBIA EL ESTADO A INACTIVO
	// ==================================================
	@GetMapping("/desactivar/{id}")
	public String desactivar(@PathVariable int id,RedirectAttributes redirect) {
		busService.desactivar(id);
		redirect.addFlashAttribute("mensajeExito","Bus desactivado correctamente");
		return "redirect:/gestionbus/lista";
	}
}

