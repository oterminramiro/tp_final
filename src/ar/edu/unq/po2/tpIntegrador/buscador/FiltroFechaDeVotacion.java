package ar.edu.unq.po2.tpIntegrador.buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpIntegrador.Muestra;

public class FiltroFechaDeVotacion implements Filtro {
	
	private String operador;
	private LocalDate fechaFiltro;

	public FiltroFechaDeVotacion(String operador, LocalDate fechaFiltro) {
		super();
		this.operador = operador;
		this.fechaFiltro = fechaFiltro;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.opiniones().get(m.opiniones().size() - 1).fecha().isBefore(fechaFiltro)).collect(Collectors.toList());
		// TO-DO filtrar segun > >= < <=
	}
}
