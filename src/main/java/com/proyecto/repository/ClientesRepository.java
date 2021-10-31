package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes,Integer>{

}
