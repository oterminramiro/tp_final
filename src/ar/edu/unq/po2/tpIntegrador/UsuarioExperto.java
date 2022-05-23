package ar.edu.unq.po2.tpIntegrador;

public class UsuarioExperto implements TipoUsuario {

	@Override
	public void recategorizar(Usuario usuario) {
	}

	@Override
	public boolean esExperto() {
		return true;
	}

}
