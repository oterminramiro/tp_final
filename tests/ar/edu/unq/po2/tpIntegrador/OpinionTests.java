package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OpinionTests {
	
	Opinion opinion;
	Usuario usuario;
	
	@BeforeEach
	void setUp() {
		usuario = Mockito.mock(Usuario.class);
		Mockito.when(usuario.esExperto()).thenReturn(true);
		opinion = new Opinion(usuario, Especie.INFESTANS);
	}
	
	
	@Test
	void testUnaOpinionTieneTipo() {
		assertEquals(Especie.INFESTANS, opinion.tipo());
	}
	
	@Test
	void testOpinionNoVinchuca() {
		opinion = new Opinion(usuario, NoVinchuca.IMAGEN_POCO_CLARA);
		assertEquals(NoVinchuca.IMAGEN_POCO_CLARA, opinion.tipo());

	}
	
	@Test
	void testUnaOpinionRegistraLaFechaDeEmision() {
		assertEquals(LocalDate.now(), opinion.fecha());
	}
	
	@Test
	void testOpinionHechaPorUnUsuarioExperto() {
		assertTrue(opinion.esDeExperto());
	}

}
