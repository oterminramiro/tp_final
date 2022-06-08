package ar.edu.unq.po2.tpIntegrador.buscador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpIntegrador.Muestra;
import ar.edu.unq.po2.tpIntegrador.Opinion;

class FiltroFechaDeVotacionTest {
	
	List<Muestra> muestras;
	List<Opinion> opinionesActuales;
	List<Opinion> opinionesViejas;
	
	@BeforeEach
	void setUp() {
		muestras = new ArrayList<>();
		opinionesActuales = new ArrayList<>();
		opinionesViejas = new ArrayList<>();
		
		this.mockearOpiniones();
		
		Muestra muestraOpinadaActual = Mockito.mock(Muestra.class);
		Mockito.when(muestraOpinadaActual.opiniones()).thenReturn(opinionesActuales);
		
		Muestra muestraOpinadaVieja = Mockito.mock(Muestra.class);
		Mockito.when(muestraOpinadaVieja.opiniones()).thenReturn(opinionesViejas);
		
		muestras.add(muestraOpinadaActual);
		muestras.add(muestraOpinadaVieja);
	}

	@Test
	void puedeFiltrarPorFechaMayor() {
		FiltroFechaDeVotacion filtro = new FiltroFechaDeVotacion(new FechaMayorEstrategia(), LocalDate.parse("2022-05-05"));
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorFechaMayorIgual() {
		FiltroFechaDeVotacion filtro = new FiltroFechaDeVotacion(new FechaMayorIgualEstrategia(), LocalDate.parse("2022-03-03"));
		
		assertEquals(2, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorFechaMenor() {
		FiltroFechaDeVotacion filtro = new FiltroFechaDeVotacion(new FechaMenorEstrategia(), LocalDate.parse("2022-05-05"));
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorFechaMenorIgual() {
		FiltroFechaDeVotacion filtro = new FiltroFechaDeVotacion(new FechaMenorIgualEstrategia(), LocalDate.parse("2022-06-06"));
		
		assertEquals(2, filtro.filtrar(muestras).size());
	}
	
	private void mockearOpiniones() {
		Opinion opinionActual = Mockito.mock(Opinion.class);
		Mockito.when(opinionActual.fecha()).thenReturn(LocalDate.parse("2022-06-06"));
		
		opinionesActuales.add(opinionActual);
		
		Opinion opinionVieja = Mockito.mock(Opinion.class);
		Mockito.when(opinionVieja.fecha()).thenReturn(LocalDate.parse("2022-03-03"));
		
		opinionesViejas.add(opinionVieja);
	}
}
