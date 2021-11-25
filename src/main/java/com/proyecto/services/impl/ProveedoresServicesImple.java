package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.Proveedores;
import com.proyecto.repository.ProveedoresRepository;
import com.proyecto.services.ProveedoresServices;

@Service
public class ProveedoresServicesImple implements ProveedoresServices{
	
	@Autowired
	private ProveedoresRepository repository;

	@Override
	public Proveedores registrar(Proveedores proveedores) {
		return repository.save(proveedores);
	}

	@Override
	public Proveedores actualizar(Proveedores proveedores) {
		return repository.save(proveedores);
	}

	@Override
	public Integer eliminar(Long idprov) {
		repository.deleteById(idprov);
		Optional<Proveedores>cli = repository.findById(idprov);
		if (cli.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<Proveedores> listar() {
		return (List<Proveedores>) repository.findAll();
	}

	@Override
	public Optional<Proveedores> obtenerPorId(Long idprov) {
		return repository.findById(idprov);
	}

	

}
