package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Organizacion implements Observer{

	private Ubicacion ubicacion;
	private TipoOrganizacion tipo;
	private int cantTrabajadores;
	private List<ZonaDeCobertura> zonasDeInteres;
	
	public Organizacion(Ubicacion ubicacion, TipoOrganizacion tipo, int cantTrabajadores) {
		super();
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.cantTrabajadores = cantTrabajadores;
		}

// Geters y Seters
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public TipoOrganizacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoOrganizacion tipo) {
		this.tipo = tipo;
	}

	public int getCantTrabajadores() {
		return cantTrabajadores;
	}

	public void setCantTrabajadores(int cantTrabajadores) {
		this.cantTrabajadores = cantTrabajadores;
	}

// Metodos de implementacion del patron Observer
	
	public void registrarseAZona(ZonaDeCobertura zona) {
		zona.addObserver(this);
		zonasDeInteres.add(zona);
	}
	
	public void salirDelRegistroDeZona(ZonaDeCobertura zona) {
		zona.deleteObserver(this);
	}

	
// Datos Recidos Por las Zonas de Cobertura(sujeto)
	
	public void cargarDeMuestra(Muestra muestra) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void validacionDeMuestra(Muestra muestra) {
	
	}

}
