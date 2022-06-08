package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Supplier;

public class ZonaDeCobertura extends Observable implements Observer {
	
	private List<Organizacion> organizacionesRegistada;
	private List<Muestra> muestrasEnZona;
	private SistemaDeMuestras sistema;
	private String nombre;
	private Ubicacion epicentro;
	private Double radio;
	private AuxiliarDeUbicacion aux;
	
	@SuppressWarnings("deprecation")
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, Double radio) {
		super();
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.aux= new AuxiliarDeUbicacion();
		this.sistema.addObserver(this);
	}
	
	public void reportarCarga(Muestra muestra) {
		
		if(this.muestraPertenece(muestra)) {
			this.muestrasEnZona.add(muestra);
			organizacionesRegistada.forEach(orga -> orga.cargarDeMuestra(muestra));
		}
		
		
	}
	
	public void reportarValidacion(Muestra muestra) {

		if(this.muestraPertenece(muestra)) {
			this.muestrasEnZona.add(muestra);
			organizacionesRegistada.forEach(orga -> orga.validacionDeMuestra(muestra));
		}
		
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

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
