package ar.edu.unq.po2.tpIntegrador.buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpIntegrador.Muestra;
import ar.edu.unq.po2.tpIntegrador.Opinion;

public class FiltroFechaDeVotacion extends FiltroFecha {

	public FiltroFechaDeVotacion(FechaEstrategia estrategia, LocalDate fecha) {
		super(estrategia, fecha);
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> this.filtrarOpiniones(m.opiniones())).collect(Collectors.toList());
	}
	
	private boolean filtrarOpiniones(List<Opinion> opiniones) {
		return opiniones.stream().anyMatch(o -> this.estrategia.comparar(o.fecha(), this.fecha));
	}
}
