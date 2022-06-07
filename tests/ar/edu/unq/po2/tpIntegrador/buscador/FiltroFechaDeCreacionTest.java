package ar.edu.unq.po2.tpIntegrador.buscador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpIntegrador.Muestra;

class FiltroFechaDeCreacionTest {

	List<Muestra> muestras;
	
	@BeforeEach
	void setUp() {
		muestras = new ArrayList<>();
		
		Muestra muestraActual = Mockito.mock(Muestra.class);
		Mockito.when(muestraActual.fecha()).thenReturn(LocalDate.parse("2022-06-06"));
		
		Muestra muestraVieja = Mockito.mock(Muestra.class);
		Mockito.when(muestraVieja.fecha()).thenReturn(LocalDate.parse("2022-03-03"));
		
		muestras.add(muestraActual);
		muestras.add(muestraVieja);
	}
	
	@Test
	void puedeFiltrarPorFechaMayor() {
		FiltroFechaDeCreacion filtro = new FiltroFechaDeCreacion(new FechaMayorEstrategia(), LocalDate.parse("2022-05-05"));
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorFechaMayorIgual() {
		FiltroFechaDeCreacion filtro = new FiltroFechaDeCreacion(new FechaMayorIgualEstrategia(), LocalDate.parse("2022-03-03"));
		
		assertEquals(2, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorFechaMenor() {
		FiltroFechaDeCreacion filtro = new FiltroFechaDeCreacion(new FechaMenorEstrategia(), LocalDate.parse("2022-05-05"));
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorFechaMenorIgual() {
		FiltroFechaDeCreacion filtro = new FiltroFechaDeCreacion(new FechaMenorIgualEstrategia(), LocalDate.parse("2022-06-06"));
		
		assertEquals(2, filtro.filtrar(muestras).size());
	}
}
