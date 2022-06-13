package ar.edu.unq.po2.tpIntegrador;

import java.util.List;

public class MuestrasCercanas implements FuncionalidadExterna{
	
	private AuxiliarDeUbicacion aux ;
	
	public double coberturaDeMuestra(ZonaDeCobertura zona, Muestra m) {

		// Tomo distancia entre epicentro y la ubicacion de la muestra
			double distaciaEntreMuestraYZona= aux.distanciaEntre(m.ubicacion(), zona.epicentro());
			 
			return zona.radio() - distaciaEntreMuestraYZona ;
			
			 
	}
	
	@Override
	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zona, Muestra m) {
		if(m.esVerificada()) {
			
			List<Muestra> verificadas=this.aux.muestrasAMenosDe(m, organizacion.getMuestrasDeInteres(),this.coberturaDeMuestra(zona, m));
			
			organizacion.MuestrasSobreSalientes(verificadas);
			
		}
		 else {

			 List<Muestra> muestrasEnZona =this.aux.muestrasAMenosDe(m,zona.getMuestrasEnZona(),this.coberturaDeMuestra(zona, m));	 
			
			organizacion.muestrasDeInteres(muestrasEnZona);

		}

	}

}
