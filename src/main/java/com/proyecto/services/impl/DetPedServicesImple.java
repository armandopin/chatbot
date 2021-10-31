package com.proyecto.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.repository.DetPedidoRepository;
import com.proyecto.services.DetPedServices;

public class DetPedServicesImple implements DetPedServices{
	
	@Autowired
	private DetPedidoRepository detpedrepository;

	@Override
	public DetallesPedidos actualizar(DetallesPedidos Detpedidos) {
		return detpedrepository.save(Detpedidos);
	}

	




	
	

}
