package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

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

	public void recategorizarConsiderando(LocalDate fechaAConsiderar, SistemaDeMuestras sistemaDeMuestras) {
		int cantidadDeEnvios = sistemaDeMuestras.enviosDelUsuarioDesdeLaFecha(this, fechaAConsiderar);
		int cantidadDeRevisiones = sistemaDeMuestras.revisionesDelUsuarioDesdeLaFecha(this, fechaAConsiderar);
		this.tipo.recategorizarConsiderando(cantidadDeEnvios, cantidadDeRevisiones, this);
	}
}
