package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trabajadores")
public class Trabajadores {

	@Id
	private int cod_trab;
	
	@Column(name = "nom_trab", nullable = false, length = 200)
	private String nom_trab;
	
	@Column(name = "ape_trab", nullable = false, length = 200)
	private String ape_trab;
	
	@Column(name = "dni_trab", nullable = false, length = 200)
	private String dni_trab;

	public int getCod_trab() {
		return cod_trab;
	}

	public void setCod_trab(int cod_trab) {
		this.cod_trab = cod_trab;
	}

	public String getNom_trab() {
		return nom_trab;
	}

	public void setNom_trab(String nom_trab) {
		this.nom_trab = nom_trab;
	}

	public String getApe_trab() {
		return ape_trab;
	}

	public void setApe_trab(String ape_trab) {
		this.ape_trab = ape_trab;
	}

	public String getDni_trab() {
		return dni_trab;
	}

	public void setDni_trab(String dni_trab) {
		this.dni_trab = dni_trab;
	}

	
	
	
}
