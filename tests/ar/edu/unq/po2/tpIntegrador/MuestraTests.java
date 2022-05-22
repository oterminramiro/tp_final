package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MuestraTests {
	
	Muestra muestra;
	Ubicacion ubicacion;
	
	@BeforeEach
	void setUp() {
		ubicacion = Mockito.mock(Ubicacion.class);
		muestra = new Muestra(Especie.INFESTANS, "images/31-infestans.jpg", ubicacion, 1523);
	}

	@Test
	void testCreacionDeUnaMuestra() {
		assertEquals(ubicacion, muestra.ubicacion());
		assertEquals(1523, muestra.idUsuario());
	}
	
	@Test
	void testTipoOpinionDeUnaMuestra() {
		assertEquals(TipoOpinion.VINCHUCA_INFESTANS, muestra.opinionDelUsuario());
	}

}
