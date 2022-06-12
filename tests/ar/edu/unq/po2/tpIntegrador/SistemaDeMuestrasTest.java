package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	void testSePuedeOpinarUnaMuestra() throws Exception {
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), Mockito.mock(Usuario.class));
		
		sistema.nuevaCarga(muestra);
		assertEquals(1, sistema.muestras().size());
		
		sistema.nuevaOpinion(muestra, Mockito.mock(Opinion.class));
		assertEquals(2, muestra.opiniones().size());
	}
	
	@Test
	void testSePuedeValidarUnaMuestra() throws Exception {
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), Mockito.mock(Usuario.class));
		
		sistema.nuevaCarga(muestra);
		assertEquals(1, sistema.muestras().size());
		
		Usuario usuario = new Usuario(68433, new UsuarioExperto());
		Usuario otroExperto = new Usuario(123, new UsuarioExperto());
		
		Opinion opinion = new Opinion(usuario, Especie.INFESTANS);
		Opinion otraOpinion = new Opinion(otroExperto, Especie.INFESTANS);
		
		sistema.nuevaOpinion(muestra, opinion);
		sistema.nuevaOpinion(muestra, otraOpinion);
		assertTrue(muestra.esVerificada());
	}
	
	@Test
	void testSePuedeBuscarUnaMuestra() throws Exception {
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), Mockito.mock(Usuario.class));
		
		sistema.nuevaCarga(muestra);
		assertEquals(1, sistema.buscar(new FiltroTipoDeEspecie(Especie.INFESTANS)).size());
	}
	
	@Test
	void testRecaterogizarAUnUsuarioBasicoSinMeritos() {
		Usuario usuario = new Usuario(912, new UsuarioBasico());
		sistema.recategorizar(usuario);
		assertFalse(usuario.esExperto());
	}
	
	@Test
	void testRecaterogizarAUnUsuarioBasicoConMasDe10CargasSuyasPeroNoConMasDe20Validaciones() throws Exception {
		Usuario usuario = new Usuario(912, new UsuarioBasico());
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), usuario);
		this.cargar(11, muestra);
		sistema.recategorizar(usuario);
		assertFalse(usuario.esExperto());
	}
	
	@Test
	void testRecaterogizarAUnUsuarioBasicoConMasDe20ValidacionesSuyasPeroNoConMasDe10Cargas() throws Exception {
		Usuario usuario = new Usuario(912, new UsuarioBasico());
		Opinion opinion = new Opinion(usuario, Especie.GUASAYANA);
		this.creadorDeMuestras(21, opinion);
		sistema.recategorizar(usuario);
		assertFalse(usuario.esExperto());
	}
	
	@Test
	void testRecaterogizarAUnUsuarioBasicoConRequisitosCumplidosParaSerExperto() throws Exception {
		Usuario usuario = new Usuario(912, new UsuarioBasico());
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), usuario);
		Opinion opinion = new Opinion(usuario, Especie.GUASAYANA);
		this.cargar(11, muestra);
		this.creadorDeMuestras(21, opinion);
		sistema.recategorizar(usuario);
		assertTrue(usuario.esExperto());
	}
	
	@Test
	void testRecaterogizarAUnUsuarioExpertoSiNoCumpleRequisitosParaSeguirSiendoExperto() {
		Usuario usuario = new Usuario(912, new UsuarioExperto()); // Empieza siendo experto
		sistema.recategorizar(usuario);
		assertFalse(usuario.esExperto()); // Termina siendo no-experto
	}
	
	@Test
	void testRecategorizarUsuarioExpertoSiNoTieneMasDe20Validaciones() throws Exception {
		Usuario usuario = new Usuario(912, new UsuarioExperto());
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), usuario);
		this.cargar(11, muestra);
		sistema.recategorizar(usuario);
		assertFalse(usuario.esExperto());
	}
	
	@Test
	void testRecategorizarUsuarioExpertoSiNoTieneMasDe10Cargas() throws Exception{
		Usuario usuario = new Usuario(912, new UsuarioExperto());
		Opinion opinion = new Opinion(usuario, Especie.GUASAYANA);
		this.creadorDeMuestras(21, opinion);
		sistema.recategorizar(usuario);
		assertFalse(usuario.esExperto());
	}
	
	@Test
	void testRecategorizarAUnUsuarioExpertoSiCumpleRequisitosDeberiaMantenerseComoExperto() throws Exception {
		Usuario usuario = new Usuario(912, new UsuarioExperto());
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", Mockito.mock(Ubicacion.class), usuario);
		Opinion opinion = new Opinion(usuario, Especie.GUASAYANA);
		this.cargar(11, muestra);
		this.creadorDeMuestras(21, opinion);
		sistema.recategorizar(usuario);
		assertTrue(usuario.esExperto());
	}
	
	@Test
	void testRecategorizarAUnUsuarioValidadoExternamenteNoDeberiaCambiarSuCondicionDeExperto() {
		Usuario usuario = new Usuario(912, new UsuarioValidadoExternamente());
		sistema.recategorizar(usuario);
		assertTrue(usuario.esExperto());
	}
	
	void creadorDeMuestras(int cantidad, Opinion opinion) throws Exception {
		// Método auxiliar a los tests para hacer carga masiva de muestras de diferentes usuarios
		List<Muestra> muestras = new ArrayList<>();
		for (int i = 1; i <= cantidad; i++) {
			Usuario usuario = new Usuario(i, new UsuarioBasico());
			Muestra muestra = new Muestra(Especie.GUASAYANA, "foto.png", Mockito.mock(Ubicacion.class), usuario);
			muestras.add(muestra);
			sistema.nuevaCarga(muestra);
		}
		muestras.forEach(muestra -> {
			try {
				sistema.nuevaOpinion(muestra, opinion);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	void cargar(int cantidad, Muestra muestra) {
		// Método auxiliar a los tests para hacer carga masiva de muestras
		for (int i = 1; i <= cantidad; i++) {
			sistema.nuevaCarga(muestra);
		}
	}
}
