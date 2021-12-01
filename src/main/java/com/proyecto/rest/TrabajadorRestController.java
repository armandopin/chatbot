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
import com.proyecto.models.Trabajador;
import com.proyecto.services.TrabajadorService;
import com.proyecto.utils.Constantes;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/trabajador")
@CrossOrigin(origins = "http://localhost:4200")
public class TrabajadorRestController {

	@Autowired
	private TrabajadorService service;

	@GetMapping("/listaTrabajador")
	public List<Trabajador> listar() {
		return service.listar();
	}

	@GetMapping("{idtra}")
	public Trabajador idTrabajador(@PathVariable Long idtra) {
		return service.obtenerPorId(idtra).get();
	}

	@PostMapping("/registraTrabajador")
	public ResponseEntity<Object> registrar(@RequestBody Trabajador trabajador) {
		Trabajador trabajadorGuardado = service.registrar(trabajador);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{]idtra}")
				.buildAndExpand(trabajadorGuardado.getIdtra()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/actualizaTrabajador")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualiza(@RequestBody Trabajador trabajador) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (trabajador.getIdtra() == 0) {
				salida.put("mensaje", "El ID de la Sede debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Trabajador objSalida = service.actualizar(trabajador);
			if (objSalida == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("{idtra}")
	public void eliminar(@PathVariable Long idtra) {
		service.eliminar(idtra);
	}

}
