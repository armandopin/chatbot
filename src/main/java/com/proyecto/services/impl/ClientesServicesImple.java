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
	private ClientesRepository repository;

	@Override
	public Clientes registrar(Clientes clientes) {
		return repository.save(clientes);
	}

	@Override
	public Integer eliminar(Long idcli) {
		repository.deleteById(idcli);
		Optional<Clientes>cli = repository.findById(idcli);
		if (cli.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public List<Clientes> listar() {
		return (List<Clientes>) repository.findAll();
	}

	@Override
	public Optional<Clientes> obtenerPorId(Long idcli) {
		return repository.findById(idcli);
	}
	@Override
	public Clientes insertaActualizaCliente(Clientes clientes) {
		// TODO Auto-generated method stub
		return repository.save(clientes);
	}
	

}
