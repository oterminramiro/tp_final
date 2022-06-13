package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Stream;

import org.mockito.ArgumentMatchers;

public class Organizacion {

	private Ubicacion ubicacion;
	private TipoOrganizacion tipo;
	private int cantTrabajadores;
	private int cantidadDeMuestrasEstudiadas;
	private int cantidadValidadasDeInteres;
	private List<ZonaDeCobertura> zonasDeInteres= new ArrayList<ZonaDeCobertura>();
	private List<Muestra> muestrasDeInteres= new ArrayList<Muestra>();

	private List<Muestra> muestrasSobreSalientes= new ArrayList<Muestra>();
	private FuncionalidadExterna funcionDeCargaDeMuestra;
	private FuncionalidadExterna funcionDeValidacionDeMuestra;
	
	
	public Organizacion(Ubicacion ubicacion, TipoOrganizacion tipo, int cantTrabajadores, FuncionalidadExterna carga,FuncionalidadExterna validacion) {
		super();
		this.setUbicacion(ubicacion);
		this.setTipo(tipo);
		this.setCantTrabajadores(cantTrabajadores);
		this.setFuncionDeCargaDeMuestra(carga);
		this.setFuncionDeValidacionDeMuestra(validacion);
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

	public List<ZonaDeCobertura> zonasDeInteres() {
	
		return this.zonasDeInteres;
	}
	
	public void setFuncionDeCargaDeMuestra(FuncionalidadExterna funcionDeCargaDeMuestra) {
		this.funcionDeCargaDeMuestra = funcionDeCargaDeMuestra;
	}

	public void setFuncionDeValidacionDeMuestra(FuncionalidadExterna funcionDeValidacionDeMuestra) {
		this.funcionDeValidacionDeMuestra = funcionDeValidacionDeMuestra;
	}

	public List<Muestra> getMuestrasDeInteres() {
		return muestrasDeInteres;
	}



	public List<Muestra> getMuestrasSobreSalientes() {
		return muestrasSobreSalientes;
	}

	

	// Valores Modificados solo por las Funciones Externas
	


	public void MuestrasSobreSalientes(List<Muestra> verificadas) {
		this.muestrasSobreSalientes.addAll(verificadas);
	}



	public void muestrasDeInteres(List<Muestra> muestraEnZona) {
		this.muestrasDeInteres.addAll(muestraEnZona);
		
	}

	
// Metodos de implementacion del patron Observer
	
	public void registrarseAZona(ZonaDeCobertura zona) {
		zona.agregarOrganizacionObservadora(this);
		zonasDeInteres.add(zona);
	}
	
	public void salirDelRegistroDeZona(ZonaDeCobertura zona) {
		zona.eliminarOrganizacion(this);
	}

	
// Datos Recidos Por las Zonas de Cobertura(sujeto)
	
	public void cargaDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		this.funcionDeCargaDeMuestra.nuevoEvento(this, zonaDeCobertura, muestra);
	}
	
	public void validacionDeMuestra(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
		this.funcionDeValidacionDeMuestra.nuevoEvento(this, zonaDeCobertura, muestra);
	}

	

}
