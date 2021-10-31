package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Proveedores;

@Repository
public interface ProveedoresRepository extends CrudRepository<Proveedores,Integer>{

}
