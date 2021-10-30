package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetPedido")
public class DetallesPedidos {

	@Id
	@ManyToOne
	private Pedidos pedidos;
	
	@Column(name = "precio_ped", precision = 10, scale = 2)
	private double precio_ped;
	
	@Column(name = "cantidad_ped", precision = 10, scale = 2)
	private int cantidad_ped;
	
	@Column(name = "sub_total", precision = 10, scale = 10)
	private double sub_total;

	public Pedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedidos pedidos) {
		this.pedidos = pedidos;
	}

	public double getPrecio_ped() {
		return precio_ped;
	}

	public void setPrecio_ped(double precio_ped) {
		this.precio_ped = precio_ped;
	}

	public int getCantidad_ped() {
		return cantidad_ped;
	}

	public void setCantidad_ped(int cantidad_ped) {
		this.cantidad_ped = cantidad_ped;
	}

	public double getSub_total() {
		return sub_total;
	}

	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}
	
	
	
}
