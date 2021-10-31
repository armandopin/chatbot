package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Pedidos;

public interface PedidosServices {
 
    Pedidos registrar(Pedidos pedidos);
	
    Pedidos actualizar(Pedidos pedidos);
	
	Integer eliminar(int cod_pedido);
	
	Optional<Pedidos>obtenerPorId(int cod_pedido);
	
	List<Pedidos> obtenerPedidos();
	
}
