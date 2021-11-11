package com.proyecto.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.repository.DetPedidoRepository;
import com.proyecto.services.DetPedServices;

@Service
public class DetPedServicesImple implements DetPedServices{
	
	@Autowired
	private DetPedidoRepository detpedrepository;

	@Override
	public DetallesPedidos actualizar(DetallesPedidos Detpedidos) {
		return detpedrepository.save(Detpedidos);
	}

	@Override
	public List<DetallesPedidos> findByCod_pedido(int cod_pedido) {
		// TODO Auto-generated method stub
		return detpedrepository.findByPedidos_codpedido(cod_pedido);
	}
	

}
