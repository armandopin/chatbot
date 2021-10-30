package com.proyecto.services;

import java.util.List;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.models.Pedidos;

public interface DetPedServices {

    DetallesPedidos registrar(DetallesPedidos Detpedidos);
	
    DetallesPedidos actualizar(Pedidos Detpedidos);
	
	Integer eliminar(int id);
	
	List<DetallesPedidos> obtenerDetallesPedidos();
	
	
}
