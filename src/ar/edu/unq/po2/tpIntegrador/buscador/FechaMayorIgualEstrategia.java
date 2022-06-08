package ar.edu.unq.po2.tpIntegrador.buscador;

import java.time.LocalDate;

public class FechaMayorIgualEstrategia implements FechaEstrategia {

	@Override
	public boolean comparar(LocalDate fechaMuestra, LocalDate fechaFiltro) {
		return fechaMuestra.isAfter(fechaFiltro) || fechaMuestra.equals(fechaFiltro);
	}

}
