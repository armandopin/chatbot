package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.models.Proveedores;
import com.proyecto.services.ProveedoresServices;

@Controller
@RequestMapping("/proveedores")
public class ProveedoresController {
	
	@Autowired
	private ProveedoresServices proveedorservice;
	
	@GetMapping
	public String listProveedores(Model map) {
		map.addAttribute("ListarProveedores", proveedorservice.obtenerProveedores());
		return "proveedores/listar";
	}
	
	@GetMapping("/nuevo")
	public String proveedorNuevo(Model map) {
		map.addAttribute("proveedor", new Proveedores());
		return "proveedores/nuevo";
	}
	
	@PostMapping("/crear")
	public String proveedorCrear(@ModelAttribute("proveedor") Proveedores proveedor) {
		proveedorservice.registrar(proveedor);
		return "redirect:/proveedores";
	}
	
	@GetMapping("/editar{cod_prov}")
	public String proveedorEditar(@ModelAttribute("cod_prov") int cod_prov, Model map) {
		map.addAttribute("proveedor", proveedorservice.obtenerPorId(cod_prov));
		return "proveedores/editar";
	}
	
	@PostMapping("/actualizar")
	public String proveedorActualizar(@ModelAttribute("proveedor") Proveedores proveedor) {
		proveedorservice.actualizar(proveedor);
		return "redirect:/proveedores";
	}
	
	@GetMapping("/eliminar{cod_prov}")
	public String proveedorEliminar(@ModelAttribute("cod_prov") int cod_prov) {
		proveedorservice.obtenerPorId(cod_prov);
		return "proveedores/proveedores";
	}

}
