package ar.edu.unq.po2.tpIntegrador;

public class Muestra {

	private int idUsuario;
	private Ubicacion ubicacion;
	private String foto;
	private Especie especie;

	public Muestra(Especie especie, String foto, Ubicacion ubicacion, int idUsuario) {
		this.especie = especie;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.idUsuario = idUsuario;
	}
	
	public Ubicacion ubicacion() {
		return this.ubicacion;
	}
	
	public int idUsuario() {
		return this.idUsuario;
	}

	public TipoOpinion opinionDelUsuario() {
		return especie.convertidaAOpinion();
	}

}
