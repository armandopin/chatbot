package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.models.Categorias;
import com.proyecto.repository.CategoriaRepository;
import com.proyecto.services.CategoriasServices;

public class CategoriasServicesImple implements CategoriasServices{

	@Autowired
	CategoriaRepository repository;
	
	@Override
	public Categorias registrar(Categorias categorias) {
		return repository.save(categorias);
	}

	@Override
	public Categorias actualizar(Categorias categorias) {
		return repository.save(categorias);
	}

	@Override
	public Integer eliminar(Long idcat) {
		repository.deleteById(idcat);
		Optional<Categorias>cat = repository.findById(idcat);
		if (cat.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<Categorias> listar() {
		return (List<Categorias>) repository.findAll();
	}

	@Override
	public Optional<Categorias> obtenerPorId(Long idcat) {
		return repository.findById(idcat);
	}

	

}
