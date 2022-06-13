package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public class AuxiliarDeUbicacion {

	public Double distanciaEntre(Ubicacion ubi1, Ubicacion ubi2) {
		
		double latPunto1=Math.toRadians(ubi1.getLatitud());
		double longPunto1=Math.toRadians(ubi1.getLongitud());
		
		double latPunto2=Math.toRadians(ubi2.getLatitud());
		double longPunto2=Math.toRadians(ubi1.getLongitud());
	
		final double radioTerreste= 6371.01; // kilometros
		
		double distancia = radioTerreste * Math.acos(Math.sin(latPunto1)* Math.sin(latPunto2)
							+ Math.cos(latPunto1) * Math.cos(latPunto2) * Math.cos(longPunto1 - longPunto2));
				
		return Math.round(distancia * 100d) / 100d;
		
		
	}

	public List<Ubicacion> lasQueEstanAMenosDe(Ubicacion referencia, List<Ubicacion> ubicaciones, double km) {
		
		List<Ubicacion> cercanas = ubicaciones
								.stream()
								.filter(ubicacion -> this.distanciaEntre(ubicacion, referencia) <= km )
								.collect(Collectors.toList());
		
		return cercanas;
	}

	public List<Muestra> muestrasAMenosDe(Muestra referencia, List<Muestra> muestras, double km) {
		
		List<Muestra> cercanas = muestras
								.stream()
								.filter(muestra -> this.distanciaEntre(muestra.ubicacion(), referencia.ubicacion()) <= km )
								.collect(Collectors.toList());

		return cercanas;
	
	}
	
}
