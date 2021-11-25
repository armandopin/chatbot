package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.DetallesPedidos;
import com.proyecto.repository.DetPedidoRepository;
import com.proyecto.services.DetPedServices;

@Service
public class DetPedServicesImple implements DetPedServices{
	
	@Autowired
	private DetPedidoRepository repository;

	@Override
	public DetallesPedidos actualizar(DetallesPedidos Detpedidos) {
		return repository.save(Detpedidos);
	}

	@Override
	public DetallesPedidos registrar(DetallesPedidos Detpedidos) {
		return repository.save(Detpedidos);
	}

	/*@Override
	public Integer eliminar(Long iddetped) {
		detpedrepository.deleteById(iddetped);
		Optional<Clientes>cli = detpedrepository.findById(iddetped);
		if (cli.isPresent()) {
			return -1;
		}
		return 1;
	}*/
	
	@Override
	public List<DetallesPedidos> listar() {
		return (List<DetallesPedidos>) repository.findAll();
	}

	@Override
	public Optional<DetallesPedidos> obtenerPorId(Long iddetped) {
		return repository.findById(iddetped);
	}

	

	
	

}
