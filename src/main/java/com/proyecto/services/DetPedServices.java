package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.DetallesPedidos;

public interface DetPedServices { 
	
	DetallesPedidos registrar(DetallesPedidos Detpedidos);
    DetallesPedidos actualizar(DetallesPedidos Detpedidos);	
    //Integer eliminar(Long iddetped);
    List<DetallesPedidos>listar();
    Optional<DetallesPedidos>obtenerPorId(Long iddetped);
    //List<DetallesPedidos> findByCod(int idpedido);
	
}
