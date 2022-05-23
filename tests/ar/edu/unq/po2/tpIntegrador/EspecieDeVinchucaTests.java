package ar.edu.unq.po2.tpIntegrador;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EspecieDeVinchucaTests {

	@Test
	void testConversionAOpinionDeUnaEspecieDeVinchuca() {
		assertEquals(TipoOpinion.VINCHUCA_GUASAYANA, Especie.GUASAYANA.convertidaAOpinion());
		assertEquals(TipoOpinion.VINCHUCA_INFESTANS, Especie.INFESTANS.convertidaAOpinion());
		assertEquals(TipoOpinion.VINCHUCA_SORDIDA, Especie.SORDIDA.convertidaAOpinion());
	}

}
