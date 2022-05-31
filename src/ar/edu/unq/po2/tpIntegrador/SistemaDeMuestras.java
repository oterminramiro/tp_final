package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public final class SistemaDeMuestras {

	private List<Muestra> muestras;
	private List<ZonaDeCobertura> zonasDeCoberturas;
	
	public void nuevaValidacion(Muestra muestra) {
		zonasDeCoberturas.forEach(z -> z.reportarValidacion(muestra));
	}
	
	public void nuevaCarga(Muestra muestra) {
		this.muestras.add(muestra);
		zonasDeCoberturas.forEach(z -> z.reportarCarga(muestra));
	}
	
	public void nuevaOpinion(Muestra muestra, Opinion opinion) {
		muestra.opinar(opinion);
		if(muestra.esVerificada()) {
			this.nuevaValidacion(muestra);
		}
	}
}
