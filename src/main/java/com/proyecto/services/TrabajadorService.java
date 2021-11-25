package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Trabajador;

public interface TrabajadorService {
	
	//public Trabajador iniciarSesion(String usuario, String clave);
	public Trabajador registrar(Trabajador trabajador);
	public Trabajador actualizar(Trabajador trabajador);
	public Integer eliminar(Long idtra);
	public List<Trabajador>listar();	
	Optional<Trabajador>obtenerPorId(Long idtra);
	//public Trabajador findByUsername(String username);
}
