package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.models.Proveedores;
import com.proyecto.services.ProveedoresServices;

@Controller
//@RequestMapping("/proveedores")
public class ProveedoresController {
	
	@Autowired
	private ProveedoresServices proveedorservice;
	
	@RequestMapping("/")
	public String inicio() {	return "inicio";  }
	
	@GetMapping("/proveedor")
	public String listProveedores(Model map) {
		map.addAttribute("ListarProveedores", proveedorservice.listar());
		return "proveedor/listar";
	}
	
	@GetMapping("/proveedores/nuevo")
	public String proveedorNuevo(Model map) {
		map.addAttribute("proveedor", new Proveedores());
		return "proveedor/nuevo";
	}
	
	@PostMapping("/proveedores/crear")
	public String proveedorCrear(@ModelAttribute("proveedor") Proveedores proveedores) {
		proveedorservice.registrar(proveedores);
		return "redirect:/proveedor";
	}
	
	@GetMapping("/proveedores/editar{idprov}")
	public String proveedorEditar(@ModelAttribute("idprov") Long idprov, Model map) {
		map.addAttribute("proveedor", proveedorservice.obtenerPorId(idprov));
		return "proveedor/editar";
	}
	
	@PostMapping("/proveedores/actualizar")
	public String proveedorActualizar(@ModelAttribute("proveedores") Proveedores proveedores) {
		proveedorservice.actualizar(proveedores);
		return "redirect:/proveedor";
	}
	
	@GetMapping("/proveedores/eliminar{idprov}")
	public String proveedorEliminar(@ModelAttribute("idprov") Long idprov) {
		proveedorservice.eliminar(idprov);
		return "redirect:/proveedor";
	}

}
