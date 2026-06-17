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

import com.viajes.entity.Ciudad;
import com.viajes.entity.Ruta;

import com.viajes.service.CiudadService;
import com.viajes.service.RutaService;

@Controller
@RequestMapping("/gestionruta")
public class RutaController {
	@Autowired
	private RutaService rutaService;
	@Autowired
	private CiudadService ciudadService;


	// LISTAR RUTAS

	@GetMapping("/lista")
	public String listar(Model model) {

		model.addAttribute("mensaje","Bienvenido al módulo de gestión de rutas");
		model.addAttribute("rutas",rutaService.listar());
		model.addAttribute("ciudades",ciudadService.listar());

		// Objeto vacio para el formulario
		Ruta ruta = new Ruta();
		ruta.setCiudadOrigen(new Ciudad());
		ruta.setCiudadDestino(new Ciudad());
		model.addAttribute("ruta",ruta);
		
		return "ruta/mantRutas";
	}

	
	// REGISTRAR RUTA
	
	@PostMapping("/registrar")
	public String registrar(Ruta ruta,RedirectAttributes redirect) {
		rutaService.registrarRuta(ruta);
		redirect.addFlashAttribute("mensajeExito","Ruta registrada correctamente");
		return "redirect:/gestionruta/lista";
	}

	
	// BUSCAR POR ID
	
	@GetMapping("/buscar/{id}")
	@ResponseBody
	public Ruta buscarPorId(@PathVariable int id) {
		return rutaService.buscarPorId(id);
	}

	// ACTUALIZAR
	@PostMapping("/actualizar")
	public String actualizar(Ruta ruta,RedirectAttributes redirect) {
		rutaService.actualizarRuta(ruta);
		redirect.addFlashAttribute("mensajeExito","Ruta actualizada correctamente");
		return "redirect:/gestionruta/lista";
	}

		// DESACTIVAR
	
	@GetMapping("/desactivar/{id}")
	public String desactivar(@PathVariable int id,RedirectAttributes redirect) {
		rutaService.desactivarEstadoRuta(id);
		redirect.addFlashAttribute("mensajeExito","Ruta desactivada correctamente");
		return "redirect:/gestionruta/lista";
	}

}