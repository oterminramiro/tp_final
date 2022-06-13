package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Supplier;

import org.mockito.ArgumentMatchers;

public class ZonaDeCobertura  implements Observer {
	
	private List<Organizacion> organizacionesRegistada= new ArrayList<Organizacion>();
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
		this.aux= new AuxiliarDeUbicacion();
		this.sistema= sistema;
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
		
		return this.organizacionesRegistada;
	}
	public List<Muestra> getMuestrasEnZona() {
		return  this.muestrasEnZona;
	}
	
	// Requerimientos ed la Clase
	public boolean muestraPertenece(Muestra muestra1) {
		// TODO Auto-generated method stub
		return this.aux.distanciaEntre(this.epicentro(), muestra1.ubicacion()) <= this.radio ;
	}

	public boolean zonaSolapada(ZonaDeCobertura zona2) {
		return zona2.radio() > (this.aux.distanciaEntre(this.epicentro(), zona2.epicentro()) - this.radio() )  ;
		
	}
	
	// Metodos de Implem,emtacion del patron Observer
	
	public void cargarMuestra(Muestra m) {
		this.muestrasEnZona.add(m);
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
		this.organizacionesRegistada.add(o);
	}
	
	public void eliminarOrganizacion(Organizacion o) {
		this.organizacionesRegistada.remove(o);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


	
}
