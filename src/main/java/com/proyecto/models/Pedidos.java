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
	private Long idped;
	
	@ManyToOne
	private Clientes clientes;
	
	@Column(name = "descripcion", length = 200)
	private String descripcion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecpedido")
	private Date fecpedido;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecEntrega")
	private Date fecEntrega;
	
}