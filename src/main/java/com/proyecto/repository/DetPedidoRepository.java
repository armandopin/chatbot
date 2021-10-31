package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.DetallesPedidos;

@Repository
public interface DetPedidoRepository extends CrudRepository<DetallesPedidos, Integer>{

}
