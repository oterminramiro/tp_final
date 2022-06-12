package ar.edu.unq.po2.tpIntegrador;

public class Usuario {
	
	private int id;
	private TipoUsuario tipo;

	public Usuario(int id, TipoUsuario tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public int id() {
		return id;
	}
	
	public boolean esExperto() {
		return tipo.esExperto();
	}

	public void actualizarTipoCon(TipoUsuario tipoUsuario) {
		this.tipo = tipoUsuario;
	}
	
	public TipoUsuario tipo() {
		return tipo;
	}

	public boolean esIgualA(Usuario unUsuario) {
		return this.id() == unUsuario.id();
	}
}
