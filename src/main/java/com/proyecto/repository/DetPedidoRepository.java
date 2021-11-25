package com.proyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.DetallesPedidos;

@Repository
public interface DetPedidoRepository extends CrudRepository<DetallesPedidos, Long>{

	public abstract List<DetallesPedidos> findByPedidos(int idpedido);

}
