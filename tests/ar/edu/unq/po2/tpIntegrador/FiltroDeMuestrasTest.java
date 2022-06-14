package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroDeMuestrasTest {

	private Organizacion unq;
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Muestra muestra4;

	private Muestra muestra5;
	private Muestra muestra6;
	private Muestra muestra7;
	private Muestra muestra8;
	private List<Muestra> muestras;
	private ZonaDeCobertura zona1;
	private ZonaDeCobertura zona2;
	
	private FiltroDeMuestras funcion;
	@BeforeEach
	void setUp() throws Exception {

		this.zona1=new ZonaDeCobertura("quilmenia",mock(Ubicacion.class), 5.d, mock(SistemaDeMuestras.class));	
		
		
		this.muestra1=new Muestra(Especie.GUASAYANA, "foto/especie1",mock(Ubicacion.class),mock(Usuario.class));
		this.muestra2=new Muestra(Especie.INFESTANS, "foto/especie2",mock(Ubicacion.class),mock(Usuario.class));
		this.muestra3=new Muestra(Especie.GUASAYANA, "foto/especie1",mock(Ubicacion.class),mock(Usuario.class));
		this.muestra4=new Muestra(Especie.GUASAYANA, "foto/especie1",mock(Ubicacion.class),mock(Usuario.class));
		
		this.muestras= Arrays.asList(this.muestra1,this.muestra2,this.muestra3);
		
		this.muestra5=mock(Muestra.class);
		this.muestra6=mock(Muestra.class);
		this.muestra7=mock(Muestra.class);
		this.muestra8=mock(Muestra.class);
		
		
		this.funcion= new FiltroDeMuestras();
		this.unq=mock(Organizacion.class);
		
	}

	@Test
	void filtrarMuestrasPOrEspecieTest() {
		List<Muestra>result =this.funcion.filtrarMuestrasPOrEspecie(muestras, muestra4);
		assertEquals(Arrays.asList(this.muestra1,this.muestra3), result);
	}

	@Test
	void filtrarMuestraValidadaTest() {
		
	}
}
