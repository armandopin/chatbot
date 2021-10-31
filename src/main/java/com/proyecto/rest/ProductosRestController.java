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
import com.proyecto.models.Productos;
import com.proyecto.services.ProductosServices;

@RestController
@RequestMapping("/api/productos")
public class ProductosRestController {
	
	@Autowired
	private ProductosServices productoservice;
	
	@GetMapping
	public List<Productos> listaProductos(){
		return productoservice.obtenerProductos();
	}
	
	@GetMapping("{cod_prod}")
	public Productos obtenerProductos(@PathVariable int cod_prod){
		return productoservice.obtenerPorId(cod_prod).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Productos productos){
		Productos productoGuardado = productoservice.registrar(productos);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_prod}")
				.buildAndExpand(productoGuardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{cod_prod}")
	public ResponseEntity<Object>actualizar(@RequestBody Productos productos, @PathVariable int cod_prod){
		productos.setId(cod_prod);
		productoservice.actualizar(productos);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{cod_prod}")
	public void eliminar(@PathVariable int cod_prod) {
		productoservice.eliminar(cod_prod);
	}

}
