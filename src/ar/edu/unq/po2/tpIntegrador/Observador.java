package ar.edu.unq.po2.tpIntegrador;

public abstract class Observador {
	
	public abstract void registrarComoObservador(Object observador);
	
	public abstract void dejarDeObservar(Object observador);
	
	public abstract void notificar(Object o);
	
	public abstract void notificar(Object sujeto, Object obj);
	
	
}
