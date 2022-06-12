package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.Muestra;

public interface FiltroEstrategia {
	public List<Muestra> ejecutar(List<Muestra> muestras, List<Filtro> listaFiltros);
}
