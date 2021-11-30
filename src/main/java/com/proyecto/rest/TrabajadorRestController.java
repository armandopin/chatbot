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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.models.Trabajador;
import com.proyecto.services.TrabajadorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/trabajador")
@CrossOrigin(origins = "http://localhost:4200")
public class TrabajadorRestController {

	@Autowired
	private TrabajadorService service;

	@GetMapping
	public List<Trabajador> listar() {
		return service.listar();
	}

	@GetMapping("{idtra}")
	public Trabajador idTrabajador(@PathVariable Long idtra) {
		return service.obtenerPorId(idtra).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Trabajador trabajador) {
		Trabajador trabajadorGuardado = service.registrar(trabajador);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{]idtra}")
				.buildAndExpand(trabajadorGuardado.getIdtra()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("{idtra}")
	public ResponseEntity<Object>actualizar(@RequestBody Trabajador trabajador, 
			@PathVariable Long idtra){
		trabajador.setIdtra(idtra);;
		service.actualizar(trabajador);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{idtra}")
	public void eliminar(@PathVariable Long idtra) {
		service.eliminar(idtra);
	}

}
