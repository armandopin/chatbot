package com.proyecto.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedidos {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_pedido;
	
	@Column(name = "desc_pedido", nullable = false, length = 200)
	private String desc_pedido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fec_pedido")
	private LocalDate fec_pedido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecEntreg_pedido")
	private Date fecEntreg_pedido;
	
	@ManyToOne
	private Categorias categorias;
	
	@ManyToOne
	private Clientes clientes;
	
}