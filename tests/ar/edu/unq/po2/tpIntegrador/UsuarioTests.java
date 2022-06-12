package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UsuarioTests {

	Usuario usuario;
	TipoUsuario tipoUsuario;

	@Test
	void testCreacionUsuarioBasico() {
		tipoUsuario = Mockito.mock(UsuarioBasico.class);
		usuario = new Usuario(68433, tipoUsuario);
		assertEquals(68433, usuario.id());
		assertEquals(tipoUsuario, usuario.tipo());
	}
	
	@Test
	void testUnUsuarioBasicoNoEsExpertoAlMomentoDeLaCreacion() {
		tipoUsuario = Mockito.mock(UsuarioBasico.class);
		usuario = new Usuario(68433, tipoUsuario);
		assertFalse(usuario.esExperto());
	}
	
	@Test
	void testCreacionUsuarioValidadoExternamente() {
		tipoUsuario = Mockito.mock(UsuarioValidadoExternamente.class);
		usuario = new Usuario(68433, tipoUsuario);
		assertEquals(68433, usuario.id());
	}
	
	@Test
	void testUnUsuarioValidadoExternamenteEsExperto() {
		tipoUsuario = Mockito.mock(UsuarioValidadoExternamente.class);
		Mockito.when(tipoUsuario.esExperto()).thenReturn(true);
		usuario = new Usuario(68433, tipoUsuario);
		assertTrue(usuario.esExperto());
	}

	@Test
	void testUsuarioIgualAOtro() {
		tipoUsuario = Mockito.mock(UsuarioValidadoExternamente.class);
		usuario = new Usuario(68433, tipoUsuario);
		Usuario otroUsuario = new Usuario(68433, tipoUsuario);
		assertTrue(usuario.esIgualA(otroUsuario));
	}
	
	@Test
	void testUsuarioNoIgualAOtro() {
		tipoUsuario = Mockito.mock(UsuarioValidadoExternamente.class);
		usuario = new Usuario(68433, tipoUsuario);
		Usuario otroUsuario = new Usuario(123, tipoUsuario);
		assertFalse(usuario.esIgualA(otroUsuario));
	}
	
	@Test
	void testCambiarElTipoDeUnUsuario() {
		tipoUsuario = Mockito.mock(UsuarioBasico.class);
		usuario = new Usuario(1234, tipoUsuario);
		TipoUsuario otroTipoDeUsuario = Mockito.mock(UsuarioExperto.class);
		usuario.actualizarTipoCon(otroTipoDeUsuario);
		assertEquals(usuario.tipo(), otroTipoDeUsuario);
	}
}
