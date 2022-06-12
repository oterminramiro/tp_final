package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpIntegrador.Especie;
import ar.edu.unq.po2.tpIntegrador.Muestra;

public class FiltroTipoDeEspecie implements Filtro {
	
	private Especie operador;

	public FiltroTipoDeEspecie(Especie operador) {
		super();
		this.operador = operador;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.especie().equals(operador)).collect(Collectors.toList());
	}
}
