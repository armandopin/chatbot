package com.proyecto.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.proyecto.services.PedidosServices;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
	
	@Autowired
	private PedidosServices pedidoservice;
	
	@GetMapping
	public List<Pedidos> listaPedidos(){
		return pedidoservice.obtenerPedidos();
	}
	
	@GetMapping("{cod_pedido}")
	public Pedidos obtenerPedidos(@PathVariable int cod_pedido){
		return pedidoservice.obtenerPorId(cod_pedido).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Pedidos pedidos){
		Pedidos pedidoGuardado = pedidoservice.registrar(pedidos);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_pedido}")
				.buildAndExpand(pedidoGuardado.getClass()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{cod_pedido}")
	public ResponseEntity<Object>actualizar(@RequestBody Pedidos pedidos, @PathVariable int cod_pedido){
		pedidos.setCod_pedido(cod_pedido);
		pedidoservice.actualizar(pedidos);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{cod_pedido}")
	public void eliminar(@PathVariable int cod_pedido) {
		pedidoservice.eliminar(cod_pedido);
	}

}
