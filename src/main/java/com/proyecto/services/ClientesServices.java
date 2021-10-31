package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Clientes;

public interface ClientesServices { 

	Clientes registrar(Clientes clientes);
	
	Clientes actualizar(Clientes clientes);
	
	Integer eliminar(int cod_cli);
	
	Optional<Clientes>obtenerPorId(int cod_cli);
	
	List<Clientes> obtenerClientes();
	
}
