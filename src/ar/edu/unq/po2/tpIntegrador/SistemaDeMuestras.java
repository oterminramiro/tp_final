package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ar.edu.unq.po2.tpIntegrador.buscador.Filtro;

public final class SistemaDeMuestras extends Observable {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<ZonaDeCobertura> zonasDeCoberturas = new ArrayList<ZonaDeCobertura>();
	
	private void nuevaValidacion(Muestra muestra) {
		zonasDeCoberturas.forEach(z -> z.reportarValidacion(muestra));
	}
	
	public void nuevaCarga(Muestra muestra) {
		this.muestras.add(muestra);
		zonasDeCoberturas.forEach(z -> z.reportarCarga(muestra));
	}
	
	public void nuevaOpinion(Muestra muestra, Opinion opinion) throws Exception {
		muestra.opinar(opinion);
		if(muestra.esVerificada()) {
			this.nuevaValidacion(muestra);
		}
	}
	
	public void recategorizar(Usuario usuario) {
		LocalDate fechaAConsiderar = LocalDate.now().minusDays(30);
		usuario.recategorizarConsiderando(fechaAConsiderar, this);
	}
	
	public int enviosDelUsuarioDesdeLaFecha(Usuario usuario, LocalDate fecha) {
		// Falta implementar este algoritmo
		return 0;
	}
	
	public int revisionesDelUsuarioDesdeLaFecha(Usuario usuario, LocalDate fecha) {
		// Falta implementar este algoritmo
		return 0;
	}
	
	public List<Muestra> muestras() {
		return this.muestras;
	}
	
	public List<Muestra> buscar(Filtro filtro){
		return filtro.filtrar(this.muestras);
	}

	public void addObserver(ZonaDeCobertura zona) {
		zonasDeCoberturas.add(zona);
	}
}
