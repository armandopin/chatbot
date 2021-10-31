package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.models.Pedidos;
import com.proyecto.repository.PedidosRepository;
import com.proyecto.services.PedidosServices;

public class PedidosServicesImple implements PedidosServices {

	@Autowired
	private PedidosRepository pedidorepository;

	@Override
	public Pedidos registrar(Pedidos pedidos) {
		return pedidorepository.save(pedidos);
	}

	@Override
	public Pedidos actualizar(Pedidos pedidos) {
		return pedidorepository.save(pedidos);
	}

	@Override
	public Integer eliminar(int cod_pedido) {
		pedidorepository.deleteById(cod_pedido);
		Optional<Pedidos> ped = pedidorepository.findById(cod_pedido);
		if (ped.isEmpty()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Pedidos> obtenerPorId(int cod_pedido) {
		return pedidorepository.findById(cod_pedido);
	}

	@Override
	public List<Pedidos> obtenerPedidos() {
		return (List<Pedidos>) pedidorepository.findAll();
	}

}
