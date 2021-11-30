package com.proyecto.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.models.Categorias;
import com.proyecto.services.CategoriasServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaRestController {

	@Autowired
	private CategoriasServices service;

	@GetMapping("/listarClientes")
	@ResponseBody

	public List<Categorias> listar() {
		return service.listar();
	}

	@GetMapping("{idcat}")
	public Categorias obtenerCategoria(@PathVariable Long idcli) {
		return service.obtenerPorId(idcli).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Categorias categorias) {
		Categorias categoriaGuardado = service.registrar(categorias);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idcat}")
				.buildAndExpand(categoriaGuardado.getIdcat()).toUri();
		return ResponseEntity.created(location).build();
	}


	@PutMapping("{idcli}")
	public ResponseEntity<Object> actualizar(@RequestBody Categorias categorias, @PathVariable Long idcat) {
		categorias.setIdcat(idcat);
		service.actualizar(categorias);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{idcli}")
	public void eliminar(@PathVariable Long idcli) {
		service.eliminar(idcli);
	}
}