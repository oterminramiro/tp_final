package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.List;

public final class SistemaDeMuestras {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<ZonaDeCobertura> zonasDeCoberturas = new ArrayList<ZonaDeCobertura>();
	
	private void nuevaValidacion(Muestra muestra) {
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
	
	public List<Muestra> muestras() {
		return this.muestras;
	}
}
