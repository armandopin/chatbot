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
import com.proyecto.models.Trabajadores;
import com.proyecto.services.TrabajadoresServices;

@RestController
@RequestMapping("/api/trabajador")
public class TrabajadorRestController {
	
	@Autowired
	private TrabajadoresServices trabajadorservice;
	
	@GetMapping
	public List<Trabajadores> listaTrabajadores(){
		return trabajadorservice.obtenerTrabajadores();
	}
	
	@GetMapping("{cod_trab}")
	public Trabajadores obtenerTrabajador(@PathVariable int cod_trab){
		return trabajadorservice.obtenerPorId(cod_trab).get();
	}
	
	@PostMapping
	public ResponseEntity<Object>registrar(@RequestBody Trabajadores trabajadores){
		Trabajadores trabajadorGuardado = trabajadorservice.registrar(trabajadores);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cod_trab}")
				.buildAndExpand(trabajadorGuardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("{cod_trab}")
	public ResponseEntity<Object>actualizar(@RequestBody Trabajadores trabajadores, @PathVariable int cod_trab){
		trabajadores.setId(cod_trab);
		trabajadorservice.actualizar(trabajadores);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{cod_trab}")
	public void eliminar(@PathVariable int cod_trab) {
		trabajadorservice.eliminar(cod_trab);
	}

}
