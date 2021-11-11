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

import com.proyecto.models.Clientes;
import com.proyecto.services.ClientesServices;


@RestController
@RequestMapping("/api/empleados")
public class ClienteRestController {

	@Autowired
	private ClientesServices clientesservices;
	
	@GetMapping
	public List<Clientes> listaPedidos(){
		return clientesservices.obtenerClientes();
	}
	
	@GetMapping("{cod_pedido}")
	public Clientes obtenerXClientes(@PathVariable int cod_cliente){
		return clientesservices.obtenerPorId(cod_cliente).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Clientes clientes){
		Clientes clienteGuardado = clientesservices.registrar(clientes);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_cliente}")
				.buildAndExpand(clienteGuardado.getCod_cli()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{cod_cliente}")
	public ResponseEntity<Object>actualizar(@RequestBody Clientes clientes, @PathVariable int cod_cliente){
		clientes.setCod_cli(cod_cliente);
		clientesservices.actualizar(clientes);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{cod_cliente}")
	public void eliminar(@PathVariable int cod_cliente) {
		clientesservices.eliminar(cod_cliente);
	}
	
}
