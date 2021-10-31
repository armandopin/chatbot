package com.proyecto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "DetPedido")
@Getter
@Setter
public class DetallesPedidos {
 
	@ManyToOne
	private Pedidos pedidos;
	
	@Column(name = "precio_ped", precision = 10, scale = 2)
	private double precio_ped;
	
	@Column(name = "cantidad_ped", precision = 10, scale = 2)
	private int cantidad_ped;
	
	@Column(name = "sub_total", precision = 10, scale = 10)
	private double sub_total;

}
