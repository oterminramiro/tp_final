package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MuestraTests {
	
	Muestra muestra;
	Ubicacion ubicacion;
	Usuario usuario;
	
	@BeforeEach
	void setUp() {
		ubicacion = Mockito.mock(Ubicacion.class);
		usuario = Mockito.mock(Usuario.class);
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", ubicacion, usuario);
	}

	@Test
	void testUnaMuestraTieneUbicacion() {
		assertEquals(ubicacion, muestra.ubicacion());
	}
	
	@Test
	void testUnaMuestraFueSubidaPorUnUsuario() {
		assertEquals(usuario, muestra.usuario());
	}
	
	@Test
	void testUnaMuestraRegistraSuFechaDeCreacion() {
		assertEquals(LocalDate.now(), muestra.fecha());
	}
	
	@Test
	void testUnaMuestraSeCreaConUnaEspecie() {
		assertEquals(Especie.INFESTANS, muestra.especie());
	}
	
	@Test
	void testUnaMuestraEmpiezaTeniendoUnaOpinion() {
		assertEquals(1, muestra.opiniones().size());
	}
	
	@Test
	void testSePuedenAgregarOpinionesAUnaMuestra() {
		muestra.opinar(Mockito.mock(Opinion.class));
		assertEquals(2, muestra.opiniones().size());
	}
	
	@Test
	void testUnaMuestraNoEmpiezaSiendoVerificada() {
		assertFalse(muestra.esVerificada());
	}
	
	@Test
	void testResultadoActualConMuestraRecienInstanciada() {
		assertTrue(muestra.resultadoActual() == Especie.INFESTANS);
	}
	
	@Test
	void testResultadoActualHabiendoOpinadoDosVecesConImagenPocoClara() {
		Opinion opinion = Mockito.mock(Opinion.class);
		Mockito.when(opinion.tipo()).thenReturn(NoVinchuca.IMAGEN_POCO_CLARA);
		muestra.opinar(opinion);
		muestra.opinar(opinion);
		assertTrue(muestra.resultadoActual() == NoVinchuca.IMAGEN_POCO_CLARA);
	}
	
	@Test
	void opinarSobreUnaMuestraSiendoExperto() {
		Opinion opinion = Mockito.mock(Opinion.class);
		Mockito.when(opinion.esDeExperto()).thenReturn(true);
		muestra.opinar(opinion);
		// A pesar de que la muestra ya empieza con una opinión, una vez que vota un experto se convierte en la única opinión cuantificable.
		assertEquals(1, muestra.opiniones().size());
	}
	
	@Test
	void opinarSobreUnaMuestraOpinadaPorExpertoSiendoExperto() {
		Opinion opinion = Mockito.mock(Opinion.class);
		Opinion otraOpinion = Mockito.mock(Opinion.class); 
		Mockito.when(opinion.esDeExperto()).thenReturn(true);
		muestra.opinar(opinion);
		Mockito.when(otraOpinion.esDeExperto()).thenReturn(true);
		muestra.opinar(otraOpinion);
		assertEquals(2, muestra.opiniones().size());
		assertTrue(muestra.esVerificada());
	}
	
	@Test
	void opinarSobreUnaMuestraQueYaVotoUnExpertoSiendoUsuarioBasico() {
		Opinion opinion = Mockito.mock(Opinion.class);
		Opinion opinionUsuarioBasico = Mockito.mock(Opinion.class); 
		Mockito.when(opinion.esDeExperto()).thenReturn(true);
		muestra.opinar(opinion);
		Mockito.when(opinionUsuarioBasico.esDeExperto()).thenReturn(false);
		muestra.opinar(opinionUsuarioBasico);
		assertEquals(1, muestra.opiniones().size());
	}

}
