package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TipoUsuarioTests {

	TipoUsuario tipo;
	
	@Test
	void testTipoUsuarioBasicoNoEsExperto() {
		tipo = new UsuarioBasico();
		assertFalse(tipo.esExperto());
	}
	
	@Test
	void testTipoUsuarioValidadoExternamenteEsExperto() {
		tipo = new UsuarioValidadoExternamente();
		assertTrue(tipo.esExperto());
	}

	@Test
	void testTipoUsuarioExperto() {
		tipo = new UsuarioExperto();
		assertTrue(tipo.esExperto());
	}



}
