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
@Table(name = "trabajador")
@Getter
@Setter
public class Trabajador{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtra;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 45)
	private String apellido;
	
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	
	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;
	
	@Column(name = "username", nullable = false, length = 20)
	private String username;
	
	@Column(name = "clave", nullable = false, length = 20)
	private String clave;


	
}