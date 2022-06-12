package ar.edu.unq.po2.tpIntegrador.buscador;

import java.util.List;

import ar.edu.unq.po2.tpIntegrador.Muestra;

public interface  Filtro {	
	public List<Muestra> filtrar(List<Muestra> muestras);
}
