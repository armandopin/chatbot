package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.models.Productos;
import com.proyecto.services.ProductosServices;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	private ProductosServices productoservice;
	
	@GetMapping
	public String listProductos(Model map) {
		map.addAttribute("ListarProductos", productoservice.listar());
		return "productos/listar";
	}
	
	@GetMapping("/nuevo")
	public String productoNuevo(Model map) {
		map.addAttribute("producto", new Productos());
		return "productos/nuevo";
	}
	
	@PostMapping("/crear")
	public String productoCrear(@ModelAttribute("producto") Productos producto) {
		productoservice.registrar(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/editar{idpro}")
	public String productoEditar(@ModelAttribute("idpro") Long idpro, Model map) {
		map.addAttribute("producto", productoservice.obtenerPorId(idpro));
		return "productos/editar";
	}
	
	@PostMapping("/actualizar")
	public String productoActualizar(@ModelAttribute("producto") Productos producto) {
		productoservice.actualizar(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/eliminar{idpro}")
	public String pedidoEliminar(@ModelAttribute("idpro") Long idpro) {
		productoservice.obtenerPorId(idpro);
		return "productos/productos";
	}

}
