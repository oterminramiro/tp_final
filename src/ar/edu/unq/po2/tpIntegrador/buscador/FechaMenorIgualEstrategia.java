package ar.edu.unq.po2.tpIntegrador.buscador;

import java.time.LocalDate;

public class FechaMenorIgualEstrategia implements FechaEstrategia {

	@Override
	public boolean comparar(LocalDate fechaMuestra, LocalDate fechaFiltro) {
		return fechaFiltro.isAfter(fechaMuestra) || fechaFiltro.equals(fechaMuestra);
	}
}
