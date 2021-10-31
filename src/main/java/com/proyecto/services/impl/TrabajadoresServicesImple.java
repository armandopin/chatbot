package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.models.Trabajadores;
import com.proyecto.repository.TrabajadoresRepository;
import com.proyecto.services.TrabajadoresServices;

public class TrabajadoresServicesImple implements TrabajadoresServices{
	
	@Autowired
	private TrabajadoresRepository trabajadoresrepository;

	@Override
	public Trabajadores registrar(Trabajadores trabajadores) {
		return trabajadoresrepository.save(trabajadores);
	}

	@Override
	public Trabajadores actualizar(Trabajadores trabajadores) {
		return trabajadoresrepository.save(trabajadores);
	}

	@Override
	public Integer eliminar(int cod_trab) {
		trabajadoresrepository.deleteById(cod_trab);
		Optional<Trabajadores> ped = trabajadoresrepository.findById(cod_trab);
		if (ped.isEmpty()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Trabajadores> obtenerPorId(int cod_trab) {
		return trabajadoresrepository.findById(cod_trab);
	}

	@Override
	public List<Trabajadores> obtenerTrabajadores() {
		return (List<Trabajadores>) trabajadoresrepository.findAll();
	}

}
