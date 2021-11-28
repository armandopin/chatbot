package com.proyecto.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.Categorias;
import com.proyecto.services.CategoriasServices;
import com.proyecto.utils.Constantes;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {

	@Autowired
	private CategoriasServices service;

	@GetMapping
	@ResponseBody
	public List<Categorias> listar() {
		return service.listar();
	}

	@GetMapping("{idcat}")
	@ResponseBody
	public Categorias obtenerCategoria(@PathVariable Long idcat) {
		return service.obtenerPorId(idcat).get();
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>registrar(@RequestBody Categorias obj){
		Map<String,Object> salida = new HashMap<>();
		try {
			Categorias objSalida =service.registrar(obj);
			if(objSalida==null) {				
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}			
			
		}catch (Exception e) {
		 e.printStackTrace();
		 salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualiza")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualiza(@RequestBody Categorias categoria) {
		Map<String, Object> salida = new HashMap<>();
		try {
			if (categoria.getIdcat() == 0) {
				salida.put("mensaje", "El ID de la Sede debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Categorias objSalida = service.actualizar(categoria);
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

	@DeleteMapping("{idcli}")
	@ResponseBody
	public void eliminar(@PathVariable Long idcli) {
		service.eliminar(idcli);
	}
}