package com.proyecto.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pedido")
public class Pedidos {
 
	@Id
	private int cod_pedido;
	
	@Column(name = "desc_pedido", nullable = false, length = 200)
	private String desc_pedido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fec_pedido")
	private Date fec_pedido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecEntreg_pedido")
	private Date fecEntreg_pedido;
	
	@ManyToOne
	private Categorias categorias;
	
	@ManyToOne
	private Clientes clientes;
	
	@ManyToOne
	private Trabajadores trabajadores;

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public String getDesc_pedido() {
		return desc_pedido;
	}

	public void setDesc_pedido(String desc_pedido) {
		this.desc_pedido = desc_pedido;
	}

	public Date getFec_pedido() {
		return fec_pedido;
	}

	public void setFec_pedido(Date fec_pedido) {
		this.fec_pedido = fec_pedido;
	}

	public Date getFecEntreg_pedido() {
		return fecEntreg_pedido;
	}

	public void setFecEntreg_pedido(Date fecEntreg_pedido) {
		this.fecEntreg_pedido = fecEntreg_pedido;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Trabajadores getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(Trabajadores trabajadores) {
		this.trabajadores = trabajadores;
	}
	
	
	
}
