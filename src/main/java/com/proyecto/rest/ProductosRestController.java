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

import com.proyecto.models.Productos;
import com.proyecto.services.ProductosServices;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductosRestController {
	
	@Autowired
	private ProductosServices productoservice;
	
	@GetMapping("/listarProductos")
	public List<Productos> listaProductos(){
		return productoservice.listar();
	}
	
	@GetMapping("{idpro}")
	public Productos obtenerProductos(@PathVariable Long idpro){
		return productoservice.obtenerPorId(idpro).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Productos productos){
		Productos productoGuardado = productoservice.registrar(productos);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idpro}")
				.buildAndExpand(productoGuardado.getIdpro()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{idpro}")
	public ResponseEntity<Object>actualizar(@RequestBody Productos productos, @PathVariable Long idpro){
		productos.setIdpro(idpro);
		productoservice.actualizar(productos);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{idpro}")
	public void eliminar(@PathVariable Long idpro) {
		productoservice.eliminar(idpro);
	}

	
}
