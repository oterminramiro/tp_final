package ar.edu.unq.po2.tpIntegrador;

public interface TipoUsuario {

	public boolean esExperto();
	public void recategorizarConsiderando(int cantidadDeEnvios, int cantidadDeRevisiones, Usuario usuario);
	
}
