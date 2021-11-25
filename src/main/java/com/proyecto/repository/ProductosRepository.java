package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Productos;

@Repository
public interface ProductosRepository extends CrudRepository<Productos,Long>{

}
