package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ZonaCoberturaTest  {


	private	ZonaDeCobertura zona1;
	private	ZonaDeCobertura zona2;
	private	ZonaDeCobertura zona3;
	private Ubicacion burzaco;
	private Ubicacion quilmes;
	private Ubicacion bernal;	
	private Muestra muestra1;
	private Muestra muestra2;
	private Organizacion unq;
	private SistemaDeMuestras sistema;

	@BeforeEach
	void setUp() throws Exception {
		
		
		
		this.sistema= mock(SistemaDeMuestras.class); //new SistemaDeMuestras();		
		this.quilmes = new Ubicacion(-34.72904d , -58.26374d);
		this.bernal= new Ubicacion(-34.71667d,-58.3d);
		this.burzaco= new Ubicacion(-34.81667,-58.4 );
		
		this.zona2= new ZonaDeCobertura("centrica",burzaco , 3d, this.sistema);
		this.zona1= new ZonaDeCobertura("centrica",quilmes , 8d,this.sistema);
		this.zona3= new ZonaDeCobertura("centrica",burzaco , 1d,this.sistema);
		
		
		
		this.muestra1= new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", bernal, Mockito.mock(Usuario.class));
		this.muestra2= new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", burzaco, Mockito.mock(Usuario.class));
		
		this.unq= mock(Organizacion.class);
	}
	
	@Test
	void muestraPerteneceTest(){
		assertTrue(this.zona1.muestraPertenece(muestra1));
	}
	@Test
	void muestraNoPerteneceTest(){
		assertFalse(this.zona1.muestraPertenece(muestra2));
	}
	
	@Test
	void zonaSolapadaTest() {
		assertTrue(this.zona1.zonaSolapada(zona2));
	}
	void zonaNoSolapadaTest() {
		assertFalse(this.zona1.zonaSolapada(zona3));
	}

	@Test
	void cargarOrganizacionComoObservador() {
		this.zona1.agregarOrganizacionObservadora(this.unq);
		assertTrue(this.zona1.organizacionesRegistradas().contains(this.unq));
	}
	
	@Test
	void eliminarOrganizacionDeLosObservadoresTest() {
		this.zona1.agregarOrganizacionObservadora(this.unq);
		this.zona1.eliminarOrganizacion(this.unq);
		
		assertFalse(this.zona1.organizacionesRegistradas().contains(this.unq));
	}

	@Test
	void reportarMuestraALosObserversTest() {
		this.zona1.agregarOrganizacionObservadora(this.unq);		
		this.zona1.reportarCarga(this.muestra1);
		assertTrue(this.zona1.getMuestrasEnZona().size()==1);
		verify(this.unq).cargaDeMuestra(this.zona1,this.muestra1);
	}
	@Test
	void reportarMuestraValidadALosObserversTest() {
		this.zona1.agregarOrganizacionObservadora(this.unq);		
		this.zona1.reportarValidacion(muestra1);
		verify(this.unq).validacionDeMuestra(this.zona1,muestra1);
	}
	@Test
	void cargarMuestraTest() {
		this.zona1.cargarMuestra(this.muestra1);
		assertEquals(1,this.zona1.getMuestrasEnZona().size());
	}

	@Test
	void muestra1PerteneceAZona1test() {
		assertTrue(this.zona1.muestraPertenece(this.muestra1));
	}
	

	
	

}
