package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class Opinion {
	
	private boolean esOpinionDeExperto;
	private Opinable tipo;
	private LocalDate fecha;

	public Opinion(Usuario usuario, Opinable tipo) {
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

}
