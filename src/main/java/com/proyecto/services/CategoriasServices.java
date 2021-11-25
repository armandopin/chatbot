package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Categorias;

public interface CategoriasServices {

	Categorias registrar(Categorias categorias);	
	Categorias actualizar(Categorias categorias);	
	Integer eliminar(Long idcat);
	List<Categorias> listar();
	Optional<Categorias>obtenerPorId(Long idcat);
}
