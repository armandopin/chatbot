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
	
	@Column(name = "nombre", length = 200)
	private String nombre;
	
	@Column(name = "apellido", length = 200)
	private String apellido;
	
	@Column(name = "direccion", length = 200)
	private String direccion;
	
	@Column(name = "telefono", length = 200)
	private String telefono;

}
