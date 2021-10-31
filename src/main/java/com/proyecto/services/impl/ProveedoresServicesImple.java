package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.models.Proveedores;
import com.proyecto.repository.ProveedoresRepository;
import com.proyecto.services.ProveedoresServices;

public class ProveedoresServicesImple implements ProveedoresServices{
	
	@Autowired
	private ProveedoresRepository proveedoresRepository;

	@Override
	public Proveedores registrar(Proveedores proveedores) {
		return proveedoresRepository.save(proveedores);
	}

	@Override
	public Proveedores actualizar(Proveedores proveedores) {
		return proveedoresRepository.save(proveedores);
	}

	@Override
	public Integer eliminar(int cod_prov) {
		proveedoresRepository.deleteById(cod_prov);
		Optional<Proveedores> ped = proveedoresRepository.findById(cod_prov);
		if (ped.isEmpty()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Proveedores> obtenerPorId(int cod_prov) {
		return proveedoresRepository.findById(cod_prov);
	}

	@Override
	public List<Proveedores> obtenerProveedores() {
		return (List<Proveedores>) proveedoresRepository.findAll();
	}

}
