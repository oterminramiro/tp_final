package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ZonaCoberturaTest  {

	ZonaDeCobertura zona1;
	ZonaDeCobertura zona2;
	Ubicacion burzaco;
	Ubicacion quilmes;
	Ubicacion bernal;	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;

	@BeforeEach
	void setUp() throws Exception {
		
		quilmes = new Ubicacion(-34.72904d , -58.26374d);
		bernal= new Ubicacion(-34.71667d,-58.3d);
		burzaco= new Ubicacion(-34.81667,-58.4 );
		
		zona2= new ZonaDeCobertura("centrica",burzaco , 3d);
		zona1= new ZonaDeCobertura("centrica",quilmes , 8d);
		
		muestra1= new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", bernal, Mockito.mock(Usuario.class));
	
	}

	@Test
	void muestra1PerteneceAZona1test() {
		assert(zona1.muestraPertenece(muestra1));
	}
	
	@Test
	void zonaSolapadasTest() {
	//	assertE(zona1.zonaSolapada(zona2));
			assertTrue(zona1.zonaSolapada(zona2));
	}
	
	

}
