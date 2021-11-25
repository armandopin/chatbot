package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.Pedidos;
import com.proyecto.repository.PedidosRepository;
import com.proyecto.services.PedidosServices;

@Service
public class PedidosServicesImple implements PedidosServices {

	@Autowired
	private PedidosRepository repository;

	@Override
	public Pedidos registrar(Pedidos pedidos) {
		return repository.save(pedidos);
	}

	@Override
	public Pedidos actualizar(Pedidos pedidos) {
		return repository.save(pedidos);
	}

	@Override
	public Integer eliminar(Long idped) {
		repository.deleteById(idped);
		Optional<Pedidos>cli = repository.findById(idped);
		if (cli.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<Pedidos> listar() {
		return (List<Pedidos>) repository.findAll();
	}

	@Override
	public Optional<Pedidos> obtenerPorId(Long idped) {
		return repository.findById(idped);
	}	

}
