package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContadorDeOpinionesTests {
	
	ContadorDeOpiniones contadorDeOpiniones;

	@BeforeEach
	void setUp() throws Exception {
		List<Opinable> opiniones = List.of(Especie.GUASAYANA, Especie.GUASAYANA, Especie.INFESTANS, NoVinchuca.IMAGEN_POCO_CLARA);
		contadorDeOpiniones = ContadorDeOpiniones.usando(opiniones);
	}

	@Test
	void testOpinionMasVotada() {
		assertEquals(contadorDeOpiniones.opinionMasVotada(), Especie.GUASAYANA);
	}
	
	@Test
	void testMayorCoincidenciaDeVotos() {
		assertEquals(contadorDeOpiniones.mayorCoincidenciaDeVotos(), 2);
	}

}
