package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Muestra {

	private Usuario usuario;
	private LocalDate fecha;
	private Ubicacion ubicacion;
	private String foto;
	private Especie especie;
	private List<Opinion> opiniones;

	public Muestra(Especie especie, String foto, Ubicacion ubicacion, Usuario usuario) {
		this.especie = especie;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.fecha = LocalDate.now();
		this.inicializarOpiniones();
	}
	
	private void inicializarOpiniones() {
		opiniones = new ArrayList<>();
		opiniones.add(new Opinion(this.usuario, this.especie.convertidaAOpinion()));
	}
	
	public List<Opinion> opiniones() {
		return this.opiniones;
	}
	
	public Especie especie() {
		return this.especie;
	}

	public LocalDate fecha() {
		return this.fecha;
	}
	
	public Ubicacion ubicacion() {
		return this.ubicacion;
	}
	
	public Usuario usuario() {
		return this.usuario;
	}

	public void opinar(Opinion unaOpinion) {
		this.opiniones.add(unaOpinion);
	}
}
