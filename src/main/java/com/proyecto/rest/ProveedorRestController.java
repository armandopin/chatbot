package com.proyecto.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.models.Pedidos;
import com.proyecto.models.Proveedores;
import com.proyecto.services.ProveedoresServices;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorRestController {
	
	@Autowired
	private ProveedoresServices proveedorservice;
	
	@GetMapping
	public List<Proveedores> listaProveedores(){
		return proveedorservice.obtenerProveedores();
	}
	
	@GetMapping("{cod_prov}")
	public Proveedores obtenerProveedores(@PathVariable int cod_prov){
		return proveedorservice.obtenerPorId(cod_prov).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Proveedores proveedores){
		Proveedores proveedorGuardado = proveedorservice.registrar(proveedores);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_prov}")
				.buildAndExpand(proveedorGuardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{cod_prov}")
	public ResponseEntity<Object>actualizar(@RequestBody Proveedores proveedores, @PathVariable int cod_prov){
		proveedores.setId(cod_prov);
		proveedorservice.actualizar(proveedores);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{cod_prov}")
	public void eliminar(@PathVariable int cod_prov) {
		proveedorservice.eliminar(cod_prov);
	}

}
