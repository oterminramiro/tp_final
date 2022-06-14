package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public class MuestrasMasJovenes implements FuncionalidadExterna{

	
	@Override
	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zona, Muestra m) {
		
		
		if(m.esVerificada()) {
			
			List<Muestra> muestrasDeInteres= this.filtrarMuestrasRegistradasAnteriormenteQue(organizacion.getMuestrasDeInteres(), m);
			List<Muestra> varificadas = muestrasDeInteres
										.stream()
										.filter(muestra -> muestra.esVerificada()== true )
										.collect(Collectors.toList());
										
			organizacion.MuestrasSobreSalientes(varificadas);
			
		}
		 else {
			List<Muestra> muestraEnZona =this.filtrarMuestrasRegistradasAnteriormenteQue(zona.getMuestrasEnZona(), m);	 
			
			organizacion.muestrasDeInteres(muestraEnZona);

		 }
	
	}



	private List<Muestra> filtrarMuestrasRegistradasAnteriormenteQue(List<Muestra> muestrasEnZona, Muestra m) {
		
		return muestrasEnZona
							.stream()
							.filter(muestra -> muestra.fecha().isAfter(m.fecha()))
							.collect(Collectors.toList());
	}


}