package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viajes.service.MarcaBusService;

@Controller
@RequestMapping("/gestionmarcabus")

public class MarcaBusController {
	@Autowired
	private MarcaBusService marcaBusService;
	
	 @GetMapping("/lista")
		public String listar(Model model) {
			model.addAttribute("mensaje","Bienvenido al módulo de Marca Bus");

			model.addAttribute("marcabus",marcaBusService.listar());

			return "marca/listaMarcaBus";
		}	
	
	
	
}
