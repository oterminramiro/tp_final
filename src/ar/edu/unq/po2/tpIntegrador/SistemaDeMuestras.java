package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ar.edu.unq.po2.tpIntegrador.buscador.FechaMayorEstrategia;
import ar.edu.unq.po2.tpIntegrador.buscador.FechaMayorIgualEstrategia;
import ar.edu.unq.po2.tpIntegrador.buscador.Filtro;
import ar.edu.unq.po2.tpIntegrador.buscador.FiltroFecha;
import ar.edu.unq.po2.tpIntegrador.buscador.FiltroFechaDeCreacion;

public  class SistemaDeMuestras extends Observable {

	private List<Muestra> muestras = new ArrayList<Muestra>();
	private List<ZonaDeCobertura> zonasDeCoberturas = new ArrayList<ZonaDeCobertura>();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
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
	
	public void recategorizar() {
		FiltroFechaDeCreacion filtro = new FiltroFechaDeCreacion(new FechaMayorIgualEstrategia(), LocalDate.now().minusDays(30));
		List <Muestra> muestrasDeLosUltimos30Dias = this.buscar(filtro);
		this.usuarios.stream().forEach(usuario -> usuario.recategorizarConsiderando(muestrasDeLosUltimos30Dias, this));
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

	public int enviosDelUsuarioEn(Usuario usuario, List<Muestra> muestras) {
		return (int) muestras.stream().filter(muestra -> muestra.fueSubidaPor(usuario)).count();
	}

	public int revisionesDelUsuarioEn(Usuario usuario, List<Muestra> muestras) {
		return (int) muestras.stream().filter(muestra -> muestra.fueOpinadaPor(usuario)).count();
	}

	public void nuevoUsuario(Usuario usuario) {
		this.usuarios.add(usuario);
	}
}
