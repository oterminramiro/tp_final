package ar.edu.unq.po2.tpIntegrador;

public class UsuarioBasico implements TipoUsuario {

	@Override
	public void recategorizar(Usuario usuario) {
	}

	@Override
	public boolean esExperto() {
		return false;
	}

}
