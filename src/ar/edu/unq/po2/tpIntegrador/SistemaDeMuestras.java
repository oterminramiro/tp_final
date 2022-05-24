package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public final class SistemaDeMuestras {

	private List<Muestra> muestras;
	private List<ZonaDeCobertura> zonasDeCoberturas;
	
	public void nuevaValidacion(Muestra muestra) {
		zonasDeCoberturas.forEach(z -> z.reportarValidacion(muestra));
	}
	
	public void nuevaCarga(Muestra muestra) {
		this.muestras.add(muestra);
		zonasDeCoberturas.forEach(z -> z.reportarCarga(muestra));
	}
	
	public void nuevaOpinion(Muestra muestra, Opinion opinion) {
		muestra.opinar(opinion);
		if(opinion.esOpinionDeExperto() || this.validarMuestra(muestra)) {
			this.nuevaValidacion(muestra);
		}
	}
	
	private boolean validarMuestra(Muestra muestra) {
		// TODO Auto-generated method stub
		return false;
	}

	public TipoOpinion resultadoActualDe(Muestra muestra) {
		return TipoOpinion.CHINCHE_FOLIADA;
	}
	
	public List<ZonaDeCobertura> zonaDeCoberturaEn(Ubicacion ubicacion){
		return zonasDeCoberturas.stream().filter( z -> this.perteneceALaZona(ubicacion, z)).collect(Collectors.toList());
	}
	
	private boolean perteneceALaZona(Ubicacion ubicacion, ZonaDeCobertura zonaDeCobertura) {
		return Math.sqrt( this.longitudAlCuadrado(zonaDeCobertura, ubicacion) + this.latitudAlCuadrado(zonaDeCobertura, ubicacion)) <= zonaDeCobertura.radio();
	}
	
	private double longitudAlCuadrado(ZonaDeCobertura zonaDeCobertura, Ubicacion ubicacion) {
		return Math.pow((zonaDeCobertura.epicentro().getLongitud() - ubicacion.getLongitud()), 2);
	}
	
	private double latitudAlCuadrado(ZonaDeCobertura zonaDeCobertura, Ubicacion ubicacion) {
		return Math.pow((zonaDeCobertura.epicentro().getLatitud() - ubicacion.getLatitud()), 2);
	}
}
