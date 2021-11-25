package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Clientes {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcli;
	
	@Column(name = "nombre", nullable = false, length = 200)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 200)
	private String apellido;
	
	@Column(name = "direccion", nullable = false, length = 200)
	private String direccion;
	
	@Column(name = "telefono", nullable = false, length = 200)
	private String telefono;

}
