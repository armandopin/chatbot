package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {

	@Id
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

	public int getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getApe_cli() {
		return ape_cli;
	}

	public void setApe_cli(String ape_cli) {
		this.ape_cli = ape_cli;
	}

	public String getDirec_cli() {
		return direc_cli;
	}

	public void setDirec_cli(String direc_cli) {
		this.direc_cli = direc_cli;
	}

	public String getCorreo_cli() {
		return correo_cli;
	}

	public void setCorreo_cli(String correo_cli) {
		this.correo_cli = correo_cli;
	}

	public String getTelef_cli() {
		return telef_cli;
	}

	public void setTelef_cli(String telef_cli) {
		this.telef_cli = telef_cli;
	}
	
	
	
	
}
