package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Productos;

public interface ProductosServices {
 
    Productos registrar(Productos productos);
	
    Productos actualizar(Productos productos);
	
	Integer eliminar(int cod_prod);
	
	Optional<Productos>obtenerPorId(int cod_prod);
	
	List<Productos> obtenerProductos();
	
}
