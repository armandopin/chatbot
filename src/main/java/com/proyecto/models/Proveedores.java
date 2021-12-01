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
	private Long idprov;
	
	@Column(name = "razons", length = 200)
	private String razons;
	
	@Column(name = "ruc", length = 11)
	private String ruc;
	
	@Column(name = "direccion", length = 100)
	private String direccion;

}
