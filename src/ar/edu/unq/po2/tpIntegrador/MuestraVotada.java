package ar.edu.unq.po2.tpIntegrador;

import java.util.List;

public class MuestraVotada extends EstadoDeMuestra {

	@Override
	public boolean esVerificadoConsiderando(List<Opinion> opiniones) {
		return false;
	}

}
