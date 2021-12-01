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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.models.Categorias;
import com.proyecto.models.Proveedores;
import com.proyecto.services.ProveedoresServices;
import com.proyecto.utils.Constantes;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorRestController {
	
	@Autowired
	private ProveedoresServices service;
	
	@GetMapping("/listarProveedores")
	public List<Proveedores> listaProveedores(){
		return service.listar();
	}
	
	@GetMapping("{idprov}")
	public Proveedores obtenerProveedores(@PathVariable Long idprov){
		return service.obtenerPorId(idprov).get();
	}
	
	@PostMapping("/registraProveedor")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>registrar(@RequestBody Proveedores obj){
		Map<String,Object> salida = new HashMap<>();
		try {
			Proveedores objSalida =service.registrar(obj);
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
	
	@PutMapping("{idprov}")
	public ResponseEntity<Object>actualizar(@RequestBody Proveedores proveedores, @PathVariable Long idprov){
		proveedores.setIdprov(idprov);
		service.actualizar(proveedores);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{idprov}")
	public void eliminar(@PathVariable Long idprov) {
		service.eliminar(idprov);
	}

}
