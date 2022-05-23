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

}
