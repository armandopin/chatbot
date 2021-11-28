package com.proyecto.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.models.Productos;
import com.proyecto.services.DetPedServices;
import com.proyecto.utils.Constantes;

@RestController
@RequestMapping("/api/detalle")
public class DetPedRestController {

	@Autowired
	private DetPedServices detpedservice;
	
	@GetMapping("{idped}")
	public Optional<DetallesPedidos> listardet(@PathVariable Long idped){
		return detpedservice.obtenerPorId(idped);
	}
		
	@PostMapping("/registrarDet")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>insertaDetPed(@RequestBody DetallesPedidos obj){
		Map<String,Object> salida = new HashMap<>();
		try {
			DetallesPedidos objSalida = detpedservice.registrar(obj);
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
	
	@PutMapping("/actualizaDet") 
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaDetPed(@RequestBody DetallesPedidos obj) {
 
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIddetped() == 0) {
				salida.put("mensaje", "El ID del Detalle debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			DetallesPedidos objSalida = detpedservice.actualizar(obj);
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
	
	
	
}
