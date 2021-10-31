package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Trabajadores;

public interface TrabajadoresServices {
 
    Trabajadores registrar(Trabajadores trabajadores);
	
    Trabajadores actualizar(Trabajadores trabajadores);
	
	Integer eliminar(int cod_trab);
	
	Optional<Trabajadores>obtenerPorId(int cod_trab);
	
	List<Trabajadores> obtenerTrabajadores();
	
	
}
