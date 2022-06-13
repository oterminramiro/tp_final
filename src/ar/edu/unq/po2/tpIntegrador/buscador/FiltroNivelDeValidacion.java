package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpIntegrador.EstadoDeMuestra;
import ar.edu.unq.po2.tpIntegrador.Muestra;

public class FiltroNivelDeValidacion implements Filtro {
	
	private EstadoDeMuestra estado;

	public FiltroNivelDeValidacion(EstadoDeMuestra estado) {
		super();
		this.estado = estado;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.estado().equals(this.estado)).collect(Collectors.toList());
	}
}
