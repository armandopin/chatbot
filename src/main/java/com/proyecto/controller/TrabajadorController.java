package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.models.Trabajador;
import com.proyecto.services.TrabajadorService;

@Controller
public class TrabajadorController {
	
	@Autowired
	private TrabajadorService service;
	
	@GetMapping("/trabajador")
	public String listar(Model map){
		map.addAttribute("listarTrabajador", service.listar());		
		return "trabajador/listar";
	}
	
	@GetMapping("/trabajador/nuevo")
	public String nuevo(Model map){
		map.addAttribute("trabajador", new Trabajador());		
		return "trabajador/nuevo";
	}
	
	@PostMapping("/trabajador/crear")
	public String crear(@ModelAttribute("trabajador")Trabajador trabajador){
		service.registrar(trabajador);
		return "redirect:/trabajador";
	}
	
	@GetMapping("trabajador/editar/{idtra}")
	public String editar(@ModelAttribute("idtra") Long idtra, Model map) {
		map.addAttribute("trabajador", service.obtenerPorId(idtra));
		return "trabajador/editar";
	}
	
	@PostMapping("trabajador/actualizar")
	public String actualizar(@ModelAttribute("trabajador") Trabajador trabajador) {
		service.actualizar(trabajador);
		return "redirect:/trabajador";
	}
	
	@GetMapping("/trabajador/eliminar/{idtra}")
	public String elimina(@ModelAttribute("idtra")Long idtra){
		service.eliminar(idtra);		
		return "redirect:/trabajador";
	}
	
}
