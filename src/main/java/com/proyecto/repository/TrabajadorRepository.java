package com.proyecto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.models.Trabajador;

@Repository
public interface TrabajadorRepository extends CrudRepository <Trabajador, Long>{

	/*
	@Query("select t from Trabajador t where t.usuario = ?1 and t.clave = ?2")
	public Trabajador iniciarSesion(String usuario, String clave);
	
	public Trabajador findByUsername(String username);
	*/
}
