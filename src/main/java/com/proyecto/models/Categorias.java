package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria") 

public class Categorias {

	@Id
	private int cod_cat;
	
	@Column(name = "nom_cat", nullable = false, length = 200)
	private String nom_cat;

	public int getCod_cat() {
		return cod_cat;
	}

	public void setCod_cat(int cod_cat) {
		this.cod_cat = cod_cat;
	}

	public String getNom_cat() {
		return nom_cat;
	}

	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}
	
	
	
	
}
