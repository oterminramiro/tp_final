package ar.edu.unq.po2.tpIntegrador.buscador;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpIntegrador.Especie;
import ar.edu.unq.po2.tpIntegrador.Muestra;

public class FiltroCompuestoTest {

	FiltroTipoDeEspecie filtroSimpleEspecieInfestans;
	FiltroTipoDeEspecie filtroSimpleEspecieSordida;
	FiltroFechaDeCreacion filtroFechaDeCreacion;
	FiltroCompuesto filtroOr;
	FiltroCompuesto filtroAnd;
	FiltroCompuesto filtroCompuesto;
	List<Muestra> muestras;

	@BeforeEach
	void setUp() {
		filtroSimpleEspecieInfestans = new FiltroTipoDeEspecie(Especie.INFESTANS);
		filtroSimpleEspecieSordida = new FiltroTipoDeEspecie(Especie.SORDIDA);
		filtroFechaDeCreacion = new FiltroFechaDeCreacion(new FechaMenorEstrategia(), LocalDate.parse("2022-05-05"));
		
		filtroOr = new FiltroCompuesto(new OrEstrategia());
		filtroOr.agregarFiltro(filtroSimpleEspecieInfestans);
		filtroOr.agregarFiltro(filtroFechaDeCreacion);
		
		filtroAnd = new FiltroCompuesto(new AndEstrategia());
		filtroAnd.agregarFiltro(filtroSimpleEspecieSordida);
		filtroAnd.agregarFiltro(filtroFechaDeCreacion);
		
		filtroCompuesto = new FiltroCompuesto(new AndEstrategia());
		filtroCompuesto.agregarFiltro(filtroOr);
		filtroCompuesto.agregarFiltro(filtroAnd);
		this.mockearMuestras();
	}
	
	private void mockearMuestras() {
		muestras = new ArrayList<>();
		
		Muestra muestraInfestans = Mockito.mock(Muestra.class);
		Mockito.when(muestraInfestans.especie()).thenReturn(Especie.INFESTANS);
		Mockito.when(muestraInfestans.fecha()).thenReturn(LocalDate.parse("2022-05-05"));
		
		Muestra muestraSordida = Mockito.mock(Muestra.class);
		Mockito.when(muestraSordida.especie()).thenReturn(Especie.SORDIDA);
		Mockito.when(muestraSordida.fecha()).thenReturn(LocalDate.parse("2022-03-03"));
		
		muestras.add(muestraInfestans);
		muestras.add(muestraSordida);
	}
	
	@Test
	void puedeFiltrarConOrTest() {
		assertEquals(2, filtroOr.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarConAndTest() {
		assertEquals(1, filtroAnd.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarConUnFiltroSimple() {
		assertEquals(1, filtroSimpleEspecieSordida.filtrar(muestras).size());
	}
	
	@Test
	void puedeFiltrarConFiltrosCompuestos() {
		assertEquals(1, filtroCompuesto.filtrar(muestras).size());
	}
}
