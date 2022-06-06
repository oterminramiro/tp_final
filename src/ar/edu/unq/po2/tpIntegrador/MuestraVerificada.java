package ar.edu.unq.po2.tpIntegrador;

import java.util.List;

public class MuestraVerificada extends EstadoDeMuestra{

	@Override
	public boolean esVerificadoConsiderando(List<Opinion> opiniones, Muestra muestraOrigen) {
		return true;
	}

}
