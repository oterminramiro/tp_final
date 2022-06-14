package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ZonaDeCobertura  implements Observer {
	
	private List<Organizacion> organizacionesRegistradas = new ArrayList<Organizacion>();
	private List<Muestra> muestrasEnZona= new ArrayList<Muestra>();
	private SistemaDeMuestras sistema;
	private String nombre;
	private Ubicacion epicentro;
	private Double radio;
	private AuxiliarDeUbicacion aux;
	
	
	public ZonaDeCobertura(String nombre, Ubicacion epicentro, Double radio, SistemaDeMuestras sistema) {
		super();
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.aux = new AuxiliarDeUbicacion();
		this.sistema = sistema;
		this.sistema.addObserver(this);
	}
	
	// geters y setters
	
	
	public Ubicacion epicentro() {
		return this.epicentro;
	}
	
	public Double radio() {
		return this.radio;
	}
	public String nombre() {
		return this.nombre;
	}

	public List<Organizacion> organizacionesRegistradas() {
		
		return this.organizacionesRegistradas;
	}
	public List<Muestra> getMuestrasEnZona() {
		return  this.muestrasEnZona;
	}
	
	// Requerimientos de la Clase
	public boolean muestraPertenece(Muestra unaMuestra) {
		return this.aux.distanciaEntre(this.epicentro(), unaMuestra.ubicacion()) <= this.radio ;
	}

	public boolean zonaSolapada(ZonaDeCobertura unaZona) {
		return unaZona.radio() > (this.aux.distanciaEntre(this.epicentro(), unaZona.epicentro()) - this.radio() )  ;
		
	}
	
	// Metodos de Implementacion del patron Observer
	public void cargarMuestra(Muestra muestra) {
		this.muestrasEnZona.add(muestra);
	}
	
	public void reportarCarga(Muestra muestra) {
		
		if(this.muestraPertenece(muestra)) {

			this.cargarMuestra(muestra);
			organizacionesRegistada.forEach(orga -> orga.cargaDeMuestra(this,muestra));

		}
		
		
	}
	
	public void reportarValidacion(Muestra muestra) {

		if(this.muestraPertenece(muestra)) {
			this.muestrasEnZona.add(muestra);
		organizacionesRegistada.forEach(orga -> orga.validacionDeMuestra(this,muestra));
		}
		
	}


	public void agregarOrganizacionObservadora(Organizacion o) {
		this.organizacionesRegistradas.add(o);
	}
	
	public void eliminarOrganizacion(Organizacion o) {
		this.organizacionesRegistradas.remove(o);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}


	
}
