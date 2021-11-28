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


import com.proyecto.models.Clientes;
import com.proyecto.services.ClientesServices;
import com.proyecto.utils.Constantes;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {

	@Autowired
	private ClientesServices clientesservices;
	
	@GetMapping
	public List<Clientes> listaPedidos(){
		return clientesservices.listar();
	}
	
	@GetMapping("{idcli}")
	public Clientes obtenerXClientes(@PathVariable Long idcli){
		return clientesservices.obtenerPorId(idcli).get();
	}
	
	@PostMapping("/registrar")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>insertaSede(@RequestBody Clientes obj){
		Map<String,Object> salida = new HashMap<>();
		try {
			Clientes objSalida =clientesservices.registrar(obj);
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
	public ResponseEntity<Map<String, Object>> actualiza(@RequestBody Clientes obj) {

		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdcli() == 0) {
				salida.put("mensaje", "El ID de la Sede debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Clientes objSalida = clientesservices.insertaActualizaCliente(obj);
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
	public void eliminar(@PathVariable Long idcli) {
		clientesservices.eliminar(idcli);
	}
	
}
