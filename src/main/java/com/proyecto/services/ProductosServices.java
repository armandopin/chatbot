package com.proyecto.services;

import java.util.List;

import com.proyecto.models.Productos;

public interface ProductosServices {
 
    Productos registrar(Productos productos);
	
    Productos actualizar(Productos productos);
	
	Integer eliminar(int id);
	
	List<Productos> obtenerProductos();
	
}
