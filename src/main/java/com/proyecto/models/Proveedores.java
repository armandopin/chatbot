package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedores {

	@Id
	private int cod_prov;
	
	@Column(name = "nom_prov", nullable = false, length = 200)
	private String nom_prov;
	
	@Column(name = "ape_prov", nullable = false, length = 200)
	private String ape_prov;
	
	@Column(name = "dni_prov", nullable = false, length = 200)
	private String dni_prov;

	public int getCod_prov() {
		return cod_prov;
	}

	public void setCod_prov(int cod_prov) {
		this.cod_prov = cod_prov;
	}

	public String getNom_prov() {
		return nom_prov;
	}

	public void setNom_prov(String nom_prov) {
		this.nom_prov = nom_prov;
	}

	public String getApe_prov() {
		return ape_prov;
	}

	public void setApe_prov(String ape_prov) {
		this.ape_prov = ape_prov;
	}

	public String getDni_prov() {
		return dni_prov;
	}

	public void setDni_prov(String dni_prov) {
		this.dni_prov = dni_prov;
	}
	
	
	
}
