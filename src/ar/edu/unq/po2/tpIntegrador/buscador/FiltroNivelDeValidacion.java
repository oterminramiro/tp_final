package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.List;
import ar.edu.unq.po2.tpIntegrador.Muestra;

public class FiltroNivelDeValidacion implements Filtro {
	
	private String operador;

	public FiltroNivelDeValidacion(String operador) {
		super();
		this.operador = operador;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		// TO-DO guardar nivel de validacion
		// return m -> m.especie().toString() == nivelDeValidacion;
		return muestras;
	}
}
