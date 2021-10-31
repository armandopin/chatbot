package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.models.Trabajadores;
import com.proyecto.services.TrabajadoresServices;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadoresController {
	
	@Autowired
	private TrabajadoresServices trabajadorservice;
	
	@GetMapping
	public String listTrabajadores(Model map) {
		map.addAttribute("ListarTrabajadores", trabajadorservice.obtenerTrabajadores());
		return "trabajadores/listar";
	}
	
	@GetMapping("/nuevo")
	public String trabajadorNuevo(Model map) {
		map.addAttribute("trabajador", new Trabajadores());
		return "trabajadores/nuevo";
	}
	
	@PostMapping("/crear")
	public String trabajadorCrear(@ModelAttribute("trabajador") Trabajadores trabajador) {
		trabajadorservice.registrar(trabajador);
		return "redirect:/trabajadores";
	}
	
	@GetMapping("/editar{cod_pedido}")
	public String trabajadorEditar(@ModelAttribute("cod_trab") int cod_trab, Model map) {
		map.addAttribute("trabajador", trabajadorservice.obtenerPorId(cod_trab));
		return "trabajadores/editar";
	}
	
	@PostMapping("/actualizar")
	public String trabajadorActualizar(@ModelAttribute("trabajador") Trabajadores trabajador) {
		trabajadorservice.actualizar(trabajador);
		return "redirect:/trabajadores";
	}
	
	@GetMapping("/eliminar{cod_trab}")
	public String trabajadorEliminar(@ModelAttribute("cod_trab") int cod_trab) {
		trabajadorservice.obtenerPorId(cod_trab);
		return "trabajadores/trabajadores";
	}

}
