package ar.edu.unq.po2.tpIntegrador.buscador;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpIntegrador.Especie;
import ar.edu.unq.po2.tpIntegrador.Muestra;

class FiltroTipoDeEspecieTest {
	
	List<Muestra> muestras;
	
	@BeforeEach
	void setUp() {
		muestras = new ArrayList<>();
		
		Muestra muestraGuasayana = Mockito.mock(Muestra.class);
		Mockito.when(muestraGuasayana.especie()).thenReturn(Especie.GUASAYANA);
		
		Muestra muestraInfestans = Mockito.mock(Muestra.class);
		Mockito.when(muestraInfestans.especie()).thenReturn(Especie.INFESTANS);
		
		Muestra muestraSordida = Mockito.mock(Muestra.class);
		Mockito.when(muestraSordida.especie()).thenReturn(Especie.SORDIDA);
		
		muestras.add(muestraGuasayana);
		muestras.add(muestraInfestans);
		muestras.add(muestraSordida);
	}
	
	@Test
	void puedeFiltrarPorInfestans() {
		FiltroTipoDeEspecie filtro = new FiltroTipoDeEspecie(Especie.INFESTANS);
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorSordida() {
		FiltroTipoDeEspecie filtro = new FiltroTipoDeEspecie(Especie.SORDIDA);
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorGuasayana() {
		FiltroTipoDeEspecie filtro = new FiltroTipoDeEspecie(Especie.GUASAYANA);
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
}
