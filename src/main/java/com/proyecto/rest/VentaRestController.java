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

import com.proyecto.models.Venta;
import com.proyecto.services.VentaService;
import com.proyecto.utils.Constantes;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/venta")
public class VentaRestController {
	
	@Autowired
	private VentaService service;
	
	@GetMapping
	private List<Venta>listar(){
		return service.listaVentas();
	}
	
	@GetMapping("{idven}")
	public Venta idVentas(@PathVariable Long idven) {
		return service.obtenerPorId(idven).get();		
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>insertaVenta(@RequestBody Venta obj){
		Map<String,Object> salida = new HashMap<>();
		try {
			Venta objSalida =service.registraVenta(obj);
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
	public ResponseEntity<Map<String, Object>> actualiza(@RequestBody Venta obj) {

		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdven() == 0) {
				salida.put("mensaje", "El ID de la Sede debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Venta objSalida = service.actualizaVenta(obj);
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
	
	@DeleteMapping("{idven}")
	public void eliminar(@PathVariable Long idven) {
		service.eliminaVenta(idven);
	}


}
