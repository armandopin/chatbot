package com.proyecto.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.services.ClientesServices;


@RestController
@RequestMapping("/api/empleados")
public class ClienteRestController {

	@Autowired
	private ClientesServices clientesServices;
	
	
	
}
