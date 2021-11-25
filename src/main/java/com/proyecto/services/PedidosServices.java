package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Pedidos;

public interface PedidosServices {
 
    Pedidos registrar(Pedidos pedidos);	
    Pedidos actualizar(Pedidos pedidos);	
	Integer eliminar(Long idped);
	List<Pedidos> listar();
	Optional<Pedidos>obtenerPorId(Long idped);
	
}
