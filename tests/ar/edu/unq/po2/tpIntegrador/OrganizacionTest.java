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
	private Muestra muestra1;
	private Muestra muestra2;
	private Muestra muestra3;
	private Muestra muestra4;
	
	private Muestra muestra5;
	private Muestra muestra6;
	private Muestra muestra7;
	private Muestra muestra8;
	@BeforeEach
	void setUp() throws Exception {
		// inicializo las funciones
		this.funcion1= new FiltroDeMuestras();
		this.funcion2= new MuestrasCercanas();
		this.funcion3= new MuestrasMasJovenes();
		
		// preparo la organizacion con las funciones 1 y 2
		
		unq=  new Organizacion(null, null, 0, this.funcion1,this.funcion1);
		this.zona1= new ZonaDeCobertura("centrica",mock(Ubicacion.class) , 8d,mock(SistemaDeMuestras.class));
		this.zona2= mock(ZonaDeCobertura.class);
		
			// Muestras de prueba
		this.muestra1=new Muestra(Especie.GUASAYANA, "foto/especie1",mock(Ubicacion.class),mock(Usuario.class));
		this.muestra2=new Muestra(Especie.INFESTANS, "foto/especie2", new Ubicacion(-34.71667d,-58.3d),mock(Usuario.class));
		this.muestra3=new Muestra(Especie.GUASAYANA, "foto/especie1",mock(Ubicacion.class),mock(Usuario.class));
		this.muestra4=new Muestra(Especie.GUASAYANA, "foto/especie1",mock(Ubicacion.class),mock(Usuario.class));
		
		this.muestra5=mock(Muestra.class);
		this.muestra6=mock(Muestra.class);
		this.muestra7=mock(Muestra.class);
		this.muestra8=mock(Muestra.class);
		
	}

	@Test
	void registrarseAunaZonaTest() {
		
		this.unq.registrarseAZona(this.zona1);
		
			assertTrue(this.unq.zonasDeInteres().contains(this.zona1));
	}
	
	@Test
	void salirDelRegistroDeLasZonas() {
		this.unq.salirDelRegistroDeZona(zona1);
		
		assertFalse(this.unq.zonasDeInteres().contains(this.zona1));
		
	}

	@Test
	void recibirResultadosDeFiltroDeMuestrasTest() {
		this.zona1.cargarMuestra(muestra1);
		this.zona1.cargarMuestra(muestra2);
		
		this.unq.cargaDeMuestra(this.zona1, this.muestra3);
	
		assertEquals(1, this.unq.getMuestrasDeInteres().size());
	}

	@Test
	void recibirResultadosDeFiltroDeMuestrasValidadasTest() {
		when(this.muestra2.esVerificada()).thenReturn(true);
	
		this.zona1.cargarMuestra(this.muestra1);
		this.zona1.cargarMuestra(this.muestra2);
		
		this.unq.validacionDeMuestra(this.zona2, this.muestra6);
		assertEquals(1, this.unq.getMuestrasSobreSalientes().size());
		
	}
}
