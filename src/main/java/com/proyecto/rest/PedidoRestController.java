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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.models.Pedidos;
import com.proyecto.services.PedidosServices;
import com.proyecto.utils.Constantes;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {
	
	@Autowired
	private PedidosServices pedidoservice;
	
	@GetMapping
	public List<Pedidos> listaPedidos(){
		return pedidoservice.listar();
	}
	
	@GetMapping("{idped}")
	public Pedidos obtenerPedidos(@PathVariable Long idped){
		return pedidoservice.obtenerPorId(idped).get();
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>insertaPedido(@RequestBody Pedidos obj){
		Map<String,Object> salida = new HashMap<>();
		try {
			Pedidos objSalida =pedidoservice.registrar(obj);
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
	public ResponseEntity<Map<String, Object>> actualiza(@RequestBody Pedidos obj) {

		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdped() == 0) {
				salida.put("mensaje", "El ID de la Sede debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Pedidos objSalida = pedidoservice.registrar(obj);
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
	
	@DeleteMapping("{idped}")
	public void eliminar(@PathVariable Long idped) {
		pedidoservice.eliminar(idped);
	}

}
