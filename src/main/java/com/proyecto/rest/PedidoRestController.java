package com.proyecto.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoRestController {
	
	@Autowired
	private PedidosServices pedidoservice;
	
	@GetMapping
	public List<Pedidos> listaPedidos(){
		return pedidoservice.listar();
	}
	
	@GetMapping("{idped}")
	public Pedidos obtenerPedidos(@PathVariable Long idped){
		return pedidoservice.obtenerPorId(idped).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Pedidos pedidos){
		Pedidos pedidoGuardado = pedidoservice.registrar(pedidos);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idped}")
				.buildAndExpand(pedidoGuardado.getClass()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{idped}")
	public ResponseEntity<Object>actualizar(@RequestBody Pedidos pedidos, @PathVariable Long idped){
		pedidos.setIdped(idped);
		pedidoservice.actualizar(pedidos);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{idped}")
	public void eliminar(@PathVariable Long idped) {
		pedidoservice.eliminar(idped);
	}

}
