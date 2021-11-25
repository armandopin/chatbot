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
@Table(name = "categoria") 
@Getter
@Setter
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcat;
	
	@Column(name = "descripcion", nullable = false, length = 200)
	private String descripcion;


}
