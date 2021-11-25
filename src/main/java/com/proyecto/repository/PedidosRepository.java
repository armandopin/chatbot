package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Pedidos;

@Repository
public interface PedidosRepository extends CrudRepository<Pedidos,Long>{

}
