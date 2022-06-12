package ar.edu.unq.po2.tpIntegrador;

public class UsuarioBasico implements TipoUsuario {

	@Override
	public boolean esExperto() {
		return false;
	}

	@Override
	public void promocionar(Usuario usuario) {
		usuario.actualizarTipoCon(new UsuarioExperto());
	}

	@Override
	public void degradar(Usuario usuario) {
		// No se hace nada
	}

}
