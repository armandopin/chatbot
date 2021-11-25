package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Categorias;

@Repository
public interface CategoriaRepository extends CrudRepository<Categorias, Long>{

}
