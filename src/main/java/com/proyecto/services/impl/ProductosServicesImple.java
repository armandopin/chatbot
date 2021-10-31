package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.models.Productos;
import com.proyecto.repository.ProductosRepository;
import com.proyecto.services.ProductosServices;

public class ProductosServicesImple implements ProductosServices{
	
	@Autowired
	private ProductosRepository productorepository;

	@Override
	public Productos registrar(Productos productos) {
		return productorepository.save(productos);
	}

	@Override
	public Productos actualizar(Productos productos) {
		return productorepository.save(productos);
	}

	@Override
	public Integer eliminar(int cod_prod) {
		productorepository.deleteById(cod_prod);
		Optional<Productos> ped = productorepository.findById(cod_prod);
		if (ped.isEmpty()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Productos> obtenerPorId(int cod_prod) {
		return productorepository.findById(cod_prod);
	}

	@Override
	public List<Productos> obtenerProductos() {
		return (List<Productos>) productorepository.findAll();
	}
	
	

}
