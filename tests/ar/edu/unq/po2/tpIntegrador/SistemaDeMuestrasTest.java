package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpIntegrador.buscador.FiltroTipoDeEspecie;

class SistemaDeMuestrasTest {
	
	SistemaDeMuestras sistema;
	Muestra muestra;
	
	@BeforeEach
	void setUp() {
		sistema = new SistemaDeMuestras();
	}
	
	@Test
	void testSePuedeCargarUnaMuestra() {
		assertEquals(0, sistema.muestras().size());
		sistema.nuevaCarga(Mockito.mock(Muestra.class));
		sistema.nuevaCarga(Mockito.mock(Muestra.class));
		assertEquals(2, sistema.muestras().size());
	}
	
	@Test
	void testSePuedeOpinarUnaMuestra() {
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), Mockito.mock(Usuario.class));
		
		sistema.nuevaCarga(muestra);
		assertEquals(1, sistema.muestras().size());
		
		sistema.nuevaOpinion(muestra, Mockito.mock(Opinion.class));
		assertEquals(2, muestra.opiniones().size());
	}
	
	@Test
	void testSePuedeValidarUnaMuestra() {
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), Mockito.mock(Usuario.class));
		
		sistema.nuevaCarga(muestra);
		assertEquals(1, sistema.muestras().size());
		
		Usuario usuario = new Usuario(68433, new UsuarioExperto());
		assertTrue(usuario.esExperto());
		
		Opinion opinion = new Opinion(usuario, Especie.INFESTANS);
		
		sistema.nuevaOpinion(muestra, opinion);
		assertTrue(muestra.esVerificada());
	}
	
	@Test
	void testSePuedeBuscarUnaMuestra() {
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), Mockito.mock(Usuario.class));
		
		sistema.nuevaCarga(muestra);
		assertEquals(1, sistema.buscar(new FiltroTipoDeEspecie(Especie.INFESTANS)).size());
	}
}
