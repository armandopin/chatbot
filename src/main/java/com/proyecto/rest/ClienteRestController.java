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
@RequestMapping("/api/clientes")
public class ClienteRestController {

	@Autowired
	private ClientesServices clientesservices;
	
	@GetMapping
	public List<Clientes> listaPedidos(){
		return clientesservices.listar();
	}
	
	@GetMapping("{idcli}")
	public Clientes obtenerXClientes(@PathVariable Long idcli){
		return clientesservices.obtenerPorId(idcli).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Clientes clientes){
		Clientes clienteGuardado = clientesservices.registrar(clientes);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idcli}")
				.buildAndExpand(clienteGuardado.getIdcli()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{idcli}")
	public ResponseEntity<Object>actualizar(@RequestBody Clientes clientes, @PathVariable Long idcli){
		clientes.setIdcli(idcli);
		clientesservices.actualizar(clientes);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{idcli}")
	public void eliminar(@PathVariable Long idcli) {
		clientesservices.eliminar(idcli);
	}
	
}
