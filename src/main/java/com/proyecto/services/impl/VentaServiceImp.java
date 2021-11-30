package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.Venta;
import com.proyecto.repository.VentaRepository;
import com.proyecto.services.VentaService;

@Service
public class VentaServiceImp implements VentaService{
	
	@Autowired
	VentaRepository repository;

	@Override
	public List<Venta> listaVentas() {		
		return (List<Venta>) repository.findAll();
	}

	@Override
	public Venta registraVenta(Venta v) {
		
		return repository.save(v);
	}

	@Override
	public Integer eliminaVenta(Long idven) {
		
		 repository.deleteById(idven);
		 Optional<Venta> venta=repository.findById(idven);
		 if(venta.isEmpty()) {
			 return -1;
		 }
		return 1;
	}

	@Override
	public Venta actualizaVenta(Venta v) {
		
		return repository.save(v);
	}

	@Override
	public Optional<Venta> obtenerPorId(Long idven) {
	
		return repository.findById(idven);
	}

}
