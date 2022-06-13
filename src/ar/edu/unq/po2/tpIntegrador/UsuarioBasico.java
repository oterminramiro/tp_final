package ar.edu.unq.po2.tpIntegrador;

public class UsuarioBasico implements TipoUsuario {

	@Override
	public boolean esExperto() {
		return false;
	}

	@Override
	public void recategorizarConsiderando(int cantidadDeEnvios, int cantidadDeRevisiones, Usuario usuario) {
		if (cantidadDeEnvios > 10 && cantidadDeRevisiones > 20) usuario.actualizarTipoCon(new UsuarioExperto());
	}

}
