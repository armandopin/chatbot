package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Trabajadores;

@Repository
public interface TrabajadoresRepository extends CrudRepository<Trabajadores,Integer>{

}
