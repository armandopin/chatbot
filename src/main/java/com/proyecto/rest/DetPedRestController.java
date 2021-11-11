package com.proyecto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.models.Pedidos;
import com.proyecto.services.DetPedServices;

@RestController
@RequestMapping("/api/detalle")
public class DetPedRestController {

	@Autowired
	private DetPedServices detpedservice;
	
	@GetMapping("{cod_pedido}")
	public List<DetallesPedidos> listardet(@PathVariable int cod_pedido){
		return detpedservice.findByCod_pedido(cod_pedido);
	}
		
	@PutMapping("{cod_pedido}")
	public ResponseEntity<Object>actualizar(@RequestBody DetallesPedidos detpedidos, @PathVariable int cod_pedido){
		detpedidos.setCod_detped(cod_pedido);
		detpedservice.actualizar(detpedidos);
		return ResponseEntity.noContent().build();
	}
}
