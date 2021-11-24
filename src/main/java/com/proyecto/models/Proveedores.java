package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proveedores")
@Getter
@Setter
public class Proveedores {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_prov;
	
	@Column(name = "nom_prov", nullable = false, length = 200)
	private String nom_prov;
	
	@Column(name = "ape_prov", nullable = false, length = 200)
	private String ape_prov;
	
	@Column(name = "dni_prov", nullable = false, length = 200)
	private String dni_prov;

}
