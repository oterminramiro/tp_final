package ar.edu.unq.po2.tpIntegrador;

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
	
}
