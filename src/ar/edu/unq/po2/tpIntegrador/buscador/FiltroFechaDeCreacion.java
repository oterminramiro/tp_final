package ar.edu.unq.po2.tpIntegrador.buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpIntegrador.Muestra;

public class FiltroFechaDeCreacion extends FiltroFecha {
	
	public FiltroFechaDeCreacion(FechaEstrategia estrategia, LocalDate fecha) {
		super(estrategia, fecha);
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> this.estrategia.comparar(m.fecha(), this.fecha)).collect(Collectors.toList());
	}
}
