package com.proyecto.services;

import java.util.List;

import com.proyecto.models.Pedidos;

public interface PedidosServices {

    Pedidos registrar(Pedidos pedidos);
	
    Pedidos actualizar(Pedidos pedidos);
	
	Integer eliminar(int id);
	
	List<Pedidos> obtenerPedidos();
	
}
