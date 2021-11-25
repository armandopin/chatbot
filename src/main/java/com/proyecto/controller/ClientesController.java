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
		map.addAttribute("ListarClientes", clienteservice.listar());
		return "clientes/listar";
	}
	
	@GetMapping("/nuevo")
	public String clienteNuevo(Model map) {
		map.addAttribute("cliente", new Clientes());
		return "cliente/nuevo";
	}
	
	@PostMapping("/crear")
	public String clienteCrear(@ModelAttribute("cliente") Clientes cliente) {
		clienteservice.registrar(cliente);
		return "redirect:/cliente";
	}
	
	@GetMapping("/editar{idcli}")
	public String clienteEditar(@ModelAttribute("idcli") Long idcli, Model map) {
		map.addAttribute("cliente", clienteservice.obtenerPorId(idcli));
		return "cliente/editar";
	}
	
	@PostMapping("/actualizar")
	public String clienteActualizar(@ModelAttribute("cliente") Clientes cliente) {
		clienteservice.actualizar(cliente);
		return "redirect:/cliente";
	}
	
	@GetMapping("/eliminar{idcli}")
	public String clienteEliminar(@ModelAttribute("idcli") Long idcli) {
		clienteservice.obtenerPorId(idcli);
		return "clientes/cliente";
	}

}
