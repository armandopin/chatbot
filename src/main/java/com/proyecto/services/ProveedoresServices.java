package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Proveedores;

public interface ProveedoresServices { 

    Proveedores registrar(Proveedores proveedores);
	
    Proveedores actualizar(Proveedores proveedores);
	
	Integer eliminar(int cod_prov);
	
	Optional<Proveedores>obtenerPorId(int cod_prov);
	
	List<Proveedores> obtenerProveedores();
	
}
