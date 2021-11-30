package com.proyecto.services;

import java.util.List;
import java.util.Optional;

import com.proyecto.models.Venta;

public interface VentaService {

	public List<Venta>listaVentas();	
	public Venta registraVenta(Venta v);
	public Integer eliminaVenta(Long idven);
	public Venta actualizaVenta(Venta v);
	Optional<Venta> obtenerPorId(Long idven);
}
