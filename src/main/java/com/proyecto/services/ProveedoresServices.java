package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Proveedores;

public interface ProveedoresServices { 

    Proveedores registrar(Proveedores proveedores);	
    Proveedores actualizar(Proveedores proveedores);	
	Integer eliminar(Long idprov);
	List<Proveedores> listar();
	Optional<Proveedores>obtenerPorId(Long idprov);
	
}
