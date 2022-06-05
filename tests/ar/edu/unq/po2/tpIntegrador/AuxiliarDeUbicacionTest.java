package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuxiliarDeUbicacionTest {
	AuxiliarDeUbicacion aux;
	Ubicacion quilmes;
	Ubicacion bernal;
	Ubicacion burzaco;
	Ubicacion solano;
	List<Ubicacion> ubicaciones;
	
	@BeforeEach
	void setUp() throws Exception {
		
		aux = new AuxiliarDeUbicacion();
		// dis entre quilmes y bernal = 3.59
		// quilmes 7 burxaco =15.82
		// quilmes y solano =7.74
		quilmes = new Ubicacion(-34.72904d , -58.26374d);
		bernal= new Ubicacion(-34.71667d,-58.3d);
		burzaco= new Ubicacion(-34.81667,-58.4 );
		solano = new Ubicacion(-34.78333,-58.31667);
		ubicaciones= Arrays.asList(bernal, solano,burzaco);
		
	}
	

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

	
	

}
