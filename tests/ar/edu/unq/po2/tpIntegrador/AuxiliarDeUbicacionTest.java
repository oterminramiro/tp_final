package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AuxiliarDeUbicacionTest {
	AuxiliarDeUbicacion aux;
	
	// Obejetos del 1° requerimiento
	Ubicacion quilmes;
	Ubicacion bernal;
	Ubicacion burzaco;
	Ubicacion solano;
	
	// Obejetos del 2° requerimiento
	
	List<Ubicacion> ubicaciones;
	List<Ubicacion> ubicacionesCercanas;
	
	// Obejetos del 3° requerimiento
	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	
	List<Muestra> muestras;
	List<Muestra> muestrasCercanas;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		aux = new AuxiliarDeUbicacion();
		
		quilmes = new Ubicacion(-34.72904d , -58.26374d);
		bernal= new Ubicacion(-34.71667d,-58.3d);
		burzaco= new Ubicacion(-34.81667,-58.4 );
		solano = new Ubicacion(-34.78333,-58.31667);
		
		ubicaciones= Arrays.asList(bernal, solano,burzaco);
		ubicacionesCercanas= Arrays.asList(bernal, solano);
	
		
		//  mock de muestras
	
		muestra1 = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", quilmes, Mockito.mock(Usuario.class));
		muestra2 = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", solano, Mockito.mock(Usuario.class));
		muestra3 = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", bernal, Mockito.mock(Usuario.class));
		muestra4 = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", burzaco, Mockito.mock(Usuario.class));
		
		muestras= Arrays.asList(muestra2,muestra3,muestra4);
		muestrasCercanas= Arrays.asList(muestra2,muestra3);
		
		
	}
	
// 1° Requerimiento 
	@Test
	void distanciaEntreQuilmesYSolanoTest() {
			assertEquals(6.04d, aux.distanciaEntre(quilmes, solano) );
	}
	@Test
	void distanciaEntreQuilmesYBernalTest() {
			assertEquals(1.38d, aux.distanciaEntre(quilmes, bernal) );
	}
	@Test
	void distanciaEntreQuilmesYBurzacoTest() {
			assertEquals(9.74d, aux.distanciaEntre(quilmes, burzaco) );
	}
	@Test
	void distanciaEntreQuilmesYQuilmesTest() {
			assertEquals(0.0d, aux.distanciaEntre(quilmes, quilmes) );
	}

	// 2° Requerimiento
	@Test
	void laDistanciasCercanasAQuilmesTest() {
		assertEquals(ubicacionesCercanas, aux.lasQueEstanAMenosDe(quilmes,ubicaciones, 7d));
	}
	

	// 3° Requerimiento
	@Test
	void muestrasCercaDeQuilmesA9KilometrosTest() {
		assertEquals(muestrasCercanas, aux.muestrasAMenosDe(muestra1,muestras, 9d));
	}
	
	
	
}
