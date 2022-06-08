package ar.edu.unq.po2.tpIntegrador;

import java.util.List;
import java.util.stream.Collectors;

public class MuestraVotada extends EstadoDeMuestra {

	@Override
	public boolean esVerificadoConsiderando(List<Opinion> opiniones, Muestra muestraOrigen) {
		int mayorCantidadDeVotos = ContadorDeOpiniones.usando(opiniones.stream().map(Opinion::tipo).collect(Collectors.toList())).mayorCoincidenciaDeVotos();
		boolean esVerificada = opiniones.stream().anyMatch(Opinion::esDeExperto) && mayorCantidadDeVotos >= 2;	
		if (esVerificada)
			muestraOrigen.cambiarEstadoDeVerificacionCon(new MuestraVerificada());
		return esVerificada;
	}

}
