package ar.edu.unq.po2.tpIntegrador;

public class UsuarioValidadoExternamente implements TipoUsuario {

	@Override
	public boolean esExperto() {
		return true;
	}

	@Override
	public void recategorizarConsiderando(int cantidadDeEnvios, int cantidadDeRevisiones, Usuario usuario) {
		// No se puede recategorizar a un usuario validado externamente
	}

	
}
