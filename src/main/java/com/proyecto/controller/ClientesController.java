package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.models.Clientes;
import com.proyecto.services.ClientesServices;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	private ClientesServices clienteservice;
	
	@GetMapping
	public String listClientes(Model map) {
		map.addAttribute("ListarClientes", clienteservice.obtenerClientes());
		return "clientes/listar";
	}
	
	@GetMapping("/nuevo")
	public String clienteNuevo(Model map) {
		map.addAttribute("cliente", new Clientes());
		return "clientes/nuevo";
	}
	
	@PostMapping("/crear")
	public String clienteCrear(@ModelAttribute("cliente") Clientes cliente) {
		clienteservice.registrar(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/editar{cod_cliente}")
	public String clienteEditar(@ModelAttribute("cod_cliente") int cod_cliente, Model map) {
		map.addAttribute("cliente", clienteservice.obtenerPorId(cod_cliente));
		return "clientes/editar";
	}
	
	@PostMapping("/actualizar")
	public String clienteActualizar(@ModelAttribute("cliente") Clientes cliente) {
		clienteservice.actualizar(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/eliminar{cod_cliente}")
	public String clienteEliminar(@ModelAttribute("cod_cliente") int cod_cliente) {
		clienteservice.obtenerPorId(cod_cliente);
		return "clientes/clientes";
	}

}
