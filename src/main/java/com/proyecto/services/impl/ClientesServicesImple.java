package com.proyecto.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.models.Clientes;
import com.proyecto.repository.ClientesRepository;
import com.proyecto.services.ClientesServices;
@Service
public class ClientesServicesImple implements ClientesServices{
	
	@Autowired
	private ClientesRepository clienterepository;

	@Override
	public Clientes registrar(Clientes clientes) {
		return clienterepository.save(clientes);
	}

	@Override
	public Clientes actualizar(Clientes clientes) {
		return clienterepository.save(clientes);
	}

	@Override
	public Integer eliminar(int cod_cli) {
		clienterepository.deleteById(cod_cli);
		Optional<Clientes> ped = clienterepository.findById(cod_cli);
		if (ped.isEmpty()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Clientes> obtenerPorId(int cod_cli) {
		return clienterepository.findById(cod_cli);
	}

	@Override
	public List<Clientes> obtenerClientes() {
		return (List<Clientes>) clienterepository.findAll();
	}

}
