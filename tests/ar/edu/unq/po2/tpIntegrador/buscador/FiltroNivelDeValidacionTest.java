package ar.edu.unq.po2.tpIntegrador.buscador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpIntegrador.Muestra;
import ar.edu.unq.po2.tpIntegrador.MuestraVerificada;
import ar.edu.unq.po2.tpIntegrador.MuestraVotada;

public class FiltroNivelDeValidacionTest {
	
	List<Muestra> muestras;
	MuestraVerificada verificada = new MuestraVerificada();
	MuestraVotada votada = new MuestraVotada();
	
	@BeforeEach
	void setUp() {
		muestras = new ArrayList<>();
		
		Muestra muestraVerificada = Mockito.mock(Muestra.class);
		Mockito.when(muestraVerificada.estado()).thenReturn(verificada);
		
		Muestra muestraVotada = Mockito.mock(Muestra.class);
		Mockito.when(muestraVotada.estado()).thenReturn(votada);
		
		muestras.add(muestraVerificada);
		muestras.add(muestraVotada);
	}
	
	@Test
	void puedeFiltrarPorVotadas() {
		FiltroNivelDeValidacion filtro = new FiltroNivelDeValidacion(votada);
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarPorVerificadas() {
		FiltroNivelDeValidacion filtro = new FiltroNivelDeValidacion(verificada);
		
		assertEquals(1, filtro.filtrar(muestras).size());
	}
}
