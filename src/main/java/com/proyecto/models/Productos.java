package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Productos {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpro;
	
	@Column(name = "descripcion", length = 200)
	private String descripcion;
	
	@Column(name = "precio", precision = 10, scale = 2)
	private double precio;
	
	@ManyToOne
	private Categorias categorias;
	
	@ManyToOne
	private Proveedores proveedores;
	
	@Column(name = "stock", precision = 10, scale = 2)
	private int stock;

}
