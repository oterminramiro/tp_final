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
		opinion = new Opinion(usuario, TipoOpinion.VINCHUCA_INFESTANS);
	}
	
	
	@Test
	void testUnaOpinionTieneTipo() {
		assertEquals(TipoOpinion.VINCHUCA_INFESTANS, opinion.tipo());
	}
	
	@Test
	void testUnaOpinionRegistraLaFechaDeEmision() {
		assertEquals(LocalDate.now(), opinion.fecha());
	}
	
	@Test
	void testOpinionHechaPorUnUsuarioExperto() {
		assertTrue(opinion.esOpinionDeExperto());
	}

}
