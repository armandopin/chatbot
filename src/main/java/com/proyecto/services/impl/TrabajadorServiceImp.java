package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.Trabajador;
import com.proyecto.repository.TrabajadorRepository;
import com.proyecto.services.TrabajadorService;

@Service
public class TrabajadorServiceImp implements TrabajadorService{

	@Autowired
	TrabajadorRepository repository;
	
	@Override
	public Trabajador registrar(Trabajador trabajador) {
		//trabajador.setClave(encoder.encode(trabajador.getClave()));
		return repository.save(trabajador);
	}

	@Override
	public List<Trabajador> listar() {
		return (List<Trabajador>) repository.findAll();
	}

	@Override
	public Trabajador actualizar(Trabajador trabajador) {
		return repository.save(trabajador);
	}

	@Override
	public Integer eliminar(Long idtra) {
		repository.deleteById(idtra);
		Optional<Trabajador>tra = repository.findById(idtra);
		if (tra.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Trabajador> obtenerPorId(Long idtra) {
		return repository.findById(idtra);
	}	

}
