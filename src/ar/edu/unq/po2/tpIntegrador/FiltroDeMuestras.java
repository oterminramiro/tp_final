package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public class FiltroDeMuestras implements FuncionalidadExterna {

	public List<Muestra> filtrarMuestrasPOrEspecie(List<Muestra> muestras, Muestra m) {
	
		return  muestras
				.stream()
				.filter(muestra -> muestra.especie() == m.especie())
				.collect(Collectors.toList());
		
	}
	
	public List<Muestra> filtrarMuestraValidada(List<Muestra> muestras, Muestra m){
		return muestras
				.stream()
				.filter(muestra -> muestra == m)
				.collect(Collectors.toList());
		
	}
	
	
	@Override
	public void nuevoEvento(Organizacion organizacion, ZonaDeCobertura zona, Muestra m) {
		
		
		if(m.esVerificada()) {
			
			List<Muestra> verificadas= this.filtrarMuestraValidada(organizacion.getMuestrasDeInteres(), m);
			organizacion.MuestrasSobreSalientes(verificadas);
			
		}
		 else {
			List<Muestra> muestraEnZona =this.filtrarMuestrasPOrEspecie(zona.getMuestrasEnZona(), m);	 
			
			organizacion.muestrasDeInteres(muestraEnZona);

		 }
	
	}


}
