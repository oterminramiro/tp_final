package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrganizacionTest {

	private Organizacion unq;
	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	private FiltroDeMuestras funcion1;
	private MuestrasCercanas funcion2;
	private MuestrasMasJovenes funcion3;
	private ImprimirMuestra funcion4;
	private Muestra muestra1;

	@BeforeEach
	void setUp() throws Exception {
		// inicializo las funciones

		this.funcion1= mock(FiltroDeMuestras.class);
		this.funcion2= mock(MuestrasCercanas.class);
		this.funcion3= mock(MuestrasMasJovenes.class);
		this.funcion4= mock(ImprimirMuestra.class);
				
		// preparo la organizacion con las funciones 1 y 2
		
		unq=  new Organizacion(null, null, 0, this.funcion1,this.funcion2);
		this.zona1= new ZonaDeCobertura("centrica",mock(Ubicacion.class) , 8d,mock(SistemaDeMuestras.class));
		
		this.muestra1=mock(Muestra.class);
	}

	@Test
	void registrarseAunaZonaTest() {
		
		this.unq.registrarseAZona(this.zona1);
		
			assertTrue(this.unq.zonasDeInteres().contains(this.zona1));
			assertTrue(this.zona1.organizacionesRegistradas().contains(this.unq));
			
	}
	
	@Test
	void salirDelRegistroDeLasZonas() {
		this.unq.salirDelRegistroDeZona(zona1);
		
		assertFalse(this.unq.zonasDeInteres().contains(this.zona1));
		
	}
	
	// Test de cambiar de Funciones
	
	@Test 
	void cambiarDeFuncionCargaDeMuestraTest() {
		this.unq.setFuncionDeCargaDeMuestra(funcion3);
		assertEquals(this.funcion3,this.unq.getFuncionDeCarga());
	}
	@Test 
	void cambiarDeFuncionDeVAlidacionDeMuestraTest() {
		this.unq.setFuncionDeValidacionDeMuestra(funcion4);
		assertEquals(this.funcion4,this.unq.getFuncionDeValidacion());
	}
	

	// probando cada una de las funciones de Carga
	
	
	@Test
	void cargarMuestraFuncion1Test() {
		
		this.unq.cargaDeMuestra(this.zona1, this.muestra1);
		verify(this.funcion1).nuevoEvento(unq, zona1, muestra1);
	}
	@Test
	void cargarMuestraFuncion2Test() {
		
		this.unq.setFuncionDeCargaDeMuestra(funcion2);
		this.unq.cargaDeMuestra(this.zona1, this.muestra1);
		verify(this.funcion2).nuevoEvento(unq, zona1, muestra1);
	}
	@Test
	void cargarMuestraFuncion3Test() {
		
		this.unq.setFuncionDeCargaDeMuestra(funcion3);
		this.unq.cargaDeMuestra(this.zona1, this.muestra1);
		verify(this.funcion3).nuevoEvento(unq, zona1, muestra1);
	}
	@Test
	void cargarMuestraFuncion4Test() {
		
		this.unq.setFuncionDeCargaDeMuestra(funcion4);
		this.unq.cargaDeMuestra(this.zona1, this.muestra1);
		verify(this.funcion4).nuevoEvento(unq, zona1, muestra1);
	}



	// probando cada una de las funciones de Validacion
	
	@Test
	void cargarValidacionFuncion1Test() {
		
		this.unq.setFuncionDeValidacionDeMuestra(funcion1);
		this.unq.validacionDeMuestra  (this.zona1, this.muestra1);
		verify(this.funcion1).nuevoEvento(unq, zona1, muestra1);
	}
	@Test
	void cargarValidacionFuncion2Test() {
		
		this.unq.setFuncionDeValidacionDeMuestra(funcion2);
		this.unq.validacionDeMuestra  (this.zona1, this.muestra1);
		verify(this.funcion2).nuevoEvento(unq, zona1, muestra1);
	}
	@Test
	void cargarValidacionFuncion3Test() {
		
		this.unq.setFuncionDeValidacionDeMuestra(funcion3);
		this.unq.validacionDeMuestra  (this.zona1, this.muestra1);
		verify(this.funcion3).nuevoEvento(unq, zona1, muestra1);
	}
	@Test
	void cargarValidacionFuncion4Test() {
		
		this.unq.setFuncionDeValidacionDeMuestra(funcion4);
		this.unq.validacionDeMuestra  (this.zona1, this.muestra1);
		verify(this.funcion4).nuevoEvento(unq, zona1, muestra1);
	}
	
	
	

	
}
