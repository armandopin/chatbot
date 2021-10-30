package com.proyecto.services;

import java.util.List;

import com.proyecto.models.Clientes;

public interface ClientesServices {

	Clientes registrar(Clientes clientes);
	
	Clientes actualizar(Clientes clientes);
	
	Integer eliminar(int id);
	
	List<Clientes> obtenerClientes();
	
}
