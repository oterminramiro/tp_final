package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class Opinion {
	
	private boolean esOpinionDeExperto;
	private Opinable tipo;
	private LocalDate fecha;
	private Usuario autor;

	public Opinion(Usuario usuario, Opinable tipo) {
		this.autor = usuario;
		// Guardo el "expertise" del usuario en la construcción para evitar que cambie el flag si el usuario cambia su estado. 
		this.esOpinionDeExperto = usuario.esExperto();
		this.tipo = tipo;
		this.fecha = LocalDate.now();
	}
	
	public LocalDate fecha() {
		return this.fecha;
	}
	
	public Opinable tipo() {
		return this.tipo;
	}
	
	public boolean esDeExperto() {
		return esOpinionDeExperto;
	}

	public Usuario autor() {
		return autor;
	}

	public boolean fueRealizadaPor(Usuario unUsuario) {
		return autor.esIgualA(unUsuario);
	}

}
