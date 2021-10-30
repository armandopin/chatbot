package com.proyecto.services;

import java.util.List;

import com.proyecto.models.Proveedores;

public interface ProveedoresServices {

    Proveedores registrar(Proveedores proveedores);
	
    Proveedores actualizar(Proveedores proveedores);
	
	Integer eliminar(int id);
	
	List<Proveedores> obtenerProveedores();
	
}
