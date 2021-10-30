package com.proyecto.services;

import java.util.List;

import com.proyecto.models.Trabajadores;

public interface TrabajadoresServices {
 
    Trabajadores registrar(Trabajadores trabajadores);
	
    Trabajadores actualizar(Trabajadores trabajadores);
	
	Integer eliminar(int id);
	
	List<Trabajadores> obtenerTrabajadores();
	
	
}
