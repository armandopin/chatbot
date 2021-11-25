package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.Productos;
import com.proyecto.repository.ProductosRepository;
import com.proyecto.services.ProductosServices;

@Service
public class ProductosServicesImple implements ProductosServices{
	
	@Autowired
	private ProductosRepository repository;

	@Override
	public Productos registrar(Productos productos) {
		return repository.save(productos);
	}

	@Override
	public Productos actualizar(Productos productos) {
		return repository.save(productos);
	}

	@Override
	public Integer eliminar(Long idpro) {
		repository.deleteById(idpro);
		Optional<Productos>cli = repository.findById(idpro);
		if (cli.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<Productos> listar() {
		return (List<Productos>) repository.findAll();
	}

	@Override
	public Optional<Productos> obtenerPorId(Long idpro) {
		return repository.findById(idpro);
	}

	
	
	

}
