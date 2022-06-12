package ar.edu.unq.po2.tpIntegrador.buscador;

import java.time.LocalDate;

public abstract class FiltroFecha implements Filtro {
	protected FechaEstrategia estrategia;
	protected LocalDate fecha;
	
	public FiltroFecha(FechaEstrategia estrategia, LocalDate fecha) {
		super();
		this.estrategia = estrategia;
		this.fecha = fecha;
	}
}
