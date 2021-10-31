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
		map.addAttribute("ListarPedidos", pedidoservice.obtenerPedidos());
		return "pedidos/listar";
	}
	
	@GetMapping("/nuevo")
	public String pedidoNuevo(Model map) {
		map.addAttribute("pedido", new Pedidos());
		return "pedidos/nuevo";
	}
	
	@PostMapping("/crear")
	public String pedidoCrear(@ModelAttribute("pedido") Pedidos pedido) {
		pedidoservice.registrar(pedido);
		return "redirect:/pedidos";
	}
	
	@GetMapping("/editar{cod_pedido}")
	public String pedidoEditar(@ModelAttribute("cod_pedido") int cod_pedido, Model map) {
		map.addAttribute("pedido", pedidoservice.obtenerPorId(cod_pedido));
		return "pedidos/editar";
	}
	
	@PostMapping("/actualizar")
	public String pedidoActualizar(@ModelAttribute("pedido") Pedidos pedido) {
		pedidoservice.actualizar(pedido);
		return "redirect:/pedidos";
	}
	
	@GetMapping("/eliminar{cod_pedido}")
	public String pedidoEliminar(@ModelAttribute("cod_pedido") int cod_pedido) {
		pedidoservice.obtenerPorId(cod_pedido);
		return "pedidos/pedidos";
	}
}
