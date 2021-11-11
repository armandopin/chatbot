package com.proyecto.services;

import java.util.List;

import com.proyecto.models.DetallesPedidos;

public interface DetPedServices { 
	
    DetallesPedidos actualizar(DetallesPedidos Detpedidos);	
    
	List<DetallesPedidos> findByCod_pedido(int cod_pedido);
	
}
