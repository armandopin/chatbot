package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {

	@Id
	private int cod_prod;
	
	@Column(name = "desc_prod", nullable = false, length = 200)
	private String desc_prod;
	
	@Column(name = "prec_prod", precision = 10, scale = 2)
	private double prec_prod;
	
	@ManyToOne
	private Categorias categorias;
	
	@Column(name = "stk_prod", precision = 10, scale = 2)
	private int stk_prod;

	public int getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(int cod_prod) {
		this.cod_prod = cod_prod;
	}

	public String getDesc_prod() {
		return desc_prod;
	}

	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}

	public double getPrec_prod() {
		return prec_prod;
	}

	public void setPrec_prod(double prec_prod) {
		this.prec_prod = prec_prod;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public int getStk_prod() {
		return stk_prod;
	}

	public void setStk_prod(int stk_prod) {
		this.stk_prod = stk_prod;
	}

	
	
}
