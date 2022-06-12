package ar.edu.unq.po2.tpIntegrador;

public class UsuarioValidadoExternamente implements TipoUsuario {

	@Override
	public boolean esExperto() {
		return true;
	}

	@Override
	public void promocionar(Usuario usuario) {
		// No se hace nada
	}

	@Override
	public void degradar(Usuario usuario) {
		// No se hace nada
	}

}
