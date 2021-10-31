package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.services.DetPedServices;

@Controller
@RequestMapping("/detpedidos")
public class DetPedidosController {
	
	@Autowired
	private DetPedServices detpedservice;
	
	@PostMapping("/actualizar")
	public String detpedidoActualizar(@ModelAttribute("detpedido") DetallesPedidos pedido) {
		detpedservice.actualizar(pedido);
		return "redirect:/detpedidos";
	}
}
