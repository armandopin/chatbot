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
public class Trabajadores {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_trab;
	
	@Column(name = "nom_trab", nullable = false, length = 200)
	private String nom_trab;
	
	@Column(name = "ape_trab", nullable = false, length = 200)
	private String ape_trab;
	
	@Column(name = "dni_trab", nullable = false, length = 200)
	private String dni_trab;
	
}
