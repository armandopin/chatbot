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
	private int cod_prod;
	
	@Column(name = "desc_prod", nullable = false, length = 200)
	private String desc_prod;
	
	@Column(name = "prec_prod", precision = 10, scale = 2)
	private double prec_prod;
	
	@ManyToOne
	private Categorias categorias;
	
	@ManyToOne
	private Proveedores proveedores;
	
	@Column(name = "stk_prod", precision = 10, scale = 2)
	private int stk_prod;

}
