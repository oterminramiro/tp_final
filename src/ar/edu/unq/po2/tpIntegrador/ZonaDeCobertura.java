package ar.edu.unq.po2.tpIntegrador;

import java.util.function.Supplier;

public class ZonaDeCobertura {
	
	private String nombre;
	private Ubicacion epicentro;
	private Double radio;
	private AuxiliarDeUbicacion aux;
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, Double radio) {
		super();
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.aux= new AuxiliarDeUbicacion();
	}
	
	public void reportarCarga(Muestra muestra) {
		return;
	}
	
	public void reportarValidacion(Muestra muestra) {
		return;
	}
	
	public Ubicacion epicentro() {
		return this.epicentro;
	}
	
	public Double radio() {
		return this.radio;
	}
	public String nombre() {
		return this.nombre;
	}


	public boolean muestraPertenece(Muestra muestra1) {
		// TODO Auto-generated method stub
		return this.aux.distanciaEntre(this.epicentro(), muestra1.ubicacion()) <= this.radio ;
	}

	public boolean zonaSolapada(ZonaDeCobertura zona2) {
		return zona2.radio() > (this.aux.distanciaEntre(this.epicentro(), zona2.epicentro()) - this.radio() )  ;
		
	}
}
