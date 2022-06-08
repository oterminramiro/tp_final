package ar.edu.unq.po2.tpIntegrador;

public class UsuarioValidadoExternamente implements TipoUsuario {

	@Override
	public void recategorizar(Usuario usuario) {
		/* Un usuario validado externamente no debe ser recategorizado 
		 											      -ltittarelli */

	}

	@Override
	public boolean esExperto() {
		return true;
	}

}
