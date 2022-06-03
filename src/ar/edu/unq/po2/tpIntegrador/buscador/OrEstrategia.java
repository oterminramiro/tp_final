package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpIntegrador.Muestra;

public class OrEstrategia implements FiltroEstrategia {

	@Override
	public List<Muestra> ejecutar(List<Muestra> muestras, List<Filtro> listaFiltros) {
		List<Muestra> resultadoFinal = new ArrayList<Muestra>();
		for (Filtro filtro : listaFiltros) {
			resultadoFinal.addAll(filtro.filtrar(muestras));
		}
		return resultadoFinal.stream().distinct().collect(Collectors.toList());
	}
}
