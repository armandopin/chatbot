package com.proyecto.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.services.DetPedServices;

@RestController
@RequestMapping("/api/detalle")
public class DetPedRestController {

	@Autowired
	private DetPedServices detpedservice;
	
	@GetMapping("{idped}")
	public Optional<DetallesPedidos> listardet(@PathVariable Long idped){
		return detpedservice.obtenerPorId(idped);
	}
		
	@PutMapping("{idped}")
	public ResponseEntity<Object>actualizar(@RequestBody DetallesPedidos detpedidos, @PathVariable Long idped){
		detpedidos.setIddetped(idped);
		detpedservice.actualizar(detpedidos);
		return ResponseEntity.noContent().build();
	}
}
