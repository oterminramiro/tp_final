package ar.edu.unq.po2.tpIntegrador.buscador;

import java.time.LocalDate;

public interface FechaEstrategia {
	public boolean comparar(LocalDate fechaMuestra, LocalDate fechaFiltro);
}
