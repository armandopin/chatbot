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
	private int cod_cli;
	
	@Column(name = "nom_cli", nullable = false, length = 200)
	private String nom_cli;
	
	@Column(name = "ape_cli", nullable = false, length = 200)
	private String ape_cli;
	
	@Column(name = "direc_cli", nullable = false, length = 200)
	private String direc_cli;
	
	@Column(name = "correo_cli", nullable = false, length = 200)
	private String correo_cli;
	
	@Column(name = "telef_cli", nullable = false, length = 200)
	private String telef_cli;

}
