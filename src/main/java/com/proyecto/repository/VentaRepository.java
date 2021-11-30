package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Venta;

@Repository
public interface VentaRepository extends CrudRepository <Venta, Long>{

}
