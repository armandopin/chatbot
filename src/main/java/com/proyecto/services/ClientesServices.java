package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Clientes;

public interface ClientesServices { 

	Clientes registrar(Clientes clientes);	
	Clientes insertaActualizaCliente(Clientes clientes);
	Integer eliminar(Long idcli);
	List<Clientes> listar();
	Optional<Clientes>obtenerPorId(Long idcli);	
}
