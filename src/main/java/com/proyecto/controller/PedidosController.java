package com.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.models.Pedidos;
import com.proyecto.services.PedidosServices;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	private PedidosServices pedidoservice;
	
	@GetMapping
	public String listPedidos(Model map) {
		map.addAttribute("ListarPedidos", pedidoservice.listar());
		return "pedido/listar";
	}
	
	@GetMapping("/nuevo")
	public String pedidoNuevo(Model map) {
		map.addAttribute("pedido", new Pedidos());
		return "pedido/nuevo";
	}
	
	@PostMapping("/crear")
	public String pedidoCrear(@ModelAttribute("pedido") Pedidos pedido) {
		pedidoservice.registrar(pedido);
		return "redirect:/pedido";
	}
	
	@GetMapping("/editar{idped}")
	public String pedidoEditar(@ModelAttribute("idped") Long idped, Model map) {
		map.addAttribute("pedido", pedidoservice.obtenerPorId(idped));
		return "pedido/editar";
	}
	
	@PostMapping("/actualizar")
	public String pedidoActualizar(@ModelAttribute("pedido") Pedidos pedido) {
		pedidoservice.actualizar(pedido);
		return "redirect:/pedido";
	}
	
	@GetMapping("/eliminar{idped}")
	public String pedidoEliminar(@ModelAttribute("idped") Long idped) {
		pedidoservice.obtenerPorId(idped);
		return "pedidos/pedido";
	}
}
