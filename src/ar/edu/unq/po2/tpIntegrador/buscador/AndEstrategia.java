package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.Muestra;

public class AndEstrategia implements FiltroEstrategia {

	@Override
	public List<Muestra> ejecutar(List<Muestra> muestras, List<Filtro> listaFiltros) {
		List<Muestra> resultadoFinal = muestras;
		for (Filtro filtro : listaFiltros) {
			resultadoFinal = filtro.filtrar(resultadoFinal);
		}
		
		return resultadoFinal;
	}

}
