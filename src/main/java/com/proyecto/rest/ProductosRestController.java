package com.proyecto.rest;

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

import com.proyecto.models.Productos;
import com.proyecto.services.ProductosServices;
import com.proyecto.utils.Constantes;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductosRestController {
	
	@Autowired
	private ProductosServices productoservice;
	
	@GetMapping("/listaProductos")
	public List<Productos> listaProductos(){
		return productoservice.listar();
	}
	
	@GetMapping("{idpro}")
	public Productos obtenerProductos(@PathVariable Long idpro){
		return productoservice.obtenerPorId(idpro).get();
	}
	
	@PostMapping("/registraProductos")
	@ResponseBody
	public ResponseEntity<Map<String,Object>>insertaProducto(@RequestBody Productos obj){
		Map<String,Object> salida = new HashMap<>();
		try {
			Productos objSalida = productoservice.registrar(obj);
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
	
	@PutMapping("/actualizaProductos")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProd(@RequestBody Productos obj) {

		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getIdpro() == 0) {
				salida.put("mensaje", "El ID de la Producto debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Productos objSalida = productoservice.actualizar(obj);
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
	
	@DeleteMapping("{idpro}")
	public void eliminar(@PathVariable Long idpro) {
		productoservice.eliminar(idpro);
	}

	
}
