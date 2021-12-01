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
@Table(name = "trabajadores")
@Getter
@Setter
public class Trabajador{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtra;
	
	@Column(name = "nombre", length = 45)
	private String nombre;
	
	@Column(name = "apellido", length = 45)
	private String apellido;
	
	@Column(name = "dni", length = 8)
	private String dni;
	
	@Column(name = "direccion", length = 100)
	private String direccion;
	
	@Column(name = "telefono", length = 9)
	private String telefono;
	

	
}