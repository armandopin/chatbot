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
@Table(name = "det_pedido")
@Getter
@Setter
public class DetallesPedidos {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetped;
	
	@ManyToOne
	private Pedidos pedidos;
	
	@ManyToOne
	private Productos productos;	
	
	@Column(name = "precio", precision = 10, scale = 2)
	private double precio;
	
	@Column(name = "cantidad", precision = 10, scale = 2)
	private int cantidad;
	
	@Column(name = "sub_total", precision = 10, scale = 10)
	private double sub_total;

}
