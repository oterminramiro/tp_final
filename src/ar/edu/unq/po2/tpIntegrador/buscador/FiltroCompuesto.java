package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpIntegrador.Muestra;

// cambiar a implement
public class FiltroCompuesto implements Filtro {
	private List<Filtro> listaFiltros = new ArrayList<Filtro>();
	private FiltroEstrategia estrategia;
	
	public FiltroCompuesto(FiltroEstrategia estrategia) {
		super();
		this.estrategia = estrategia;
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return this.estrategia.ejecutar(muestras, listaFiltros);
	}
	
	public void agregarFiltro(Filtro filtro) {
		listaFiltros.add(filtro);
	}
	
	public void eliminarFiltro(Filtro filtro) {
		listaFiltros.remove(filtro);
	}
}
