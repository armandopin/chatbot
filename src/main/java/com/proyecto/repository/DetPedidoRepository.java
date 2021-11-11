package com.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.DetallesPedidos;

@Repository
public interface DetPedidoRepository extends CrudRepository<DetallesPedidos, Integer>{

	public abstract List<DetallesPedidos> findByPedidos_codpedido(int cod_pedido);

}
