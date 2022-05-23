package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;

public class Opinion {
	
	private boolean esOpinionDeExperto;
	private TipoOpinion tipo;
	private LocalDate fecha;

	public Opinion(Usuario usuario, TipoOpinion tipo) {
		this.esOpinionDeExperto = usuario.esExperto();
		this.tipo = tipo;
		this.fecha = LocalDate.now();
	}
	
	public LocalDate fecha() {
		return this.fecha;
	}
	
	public TipoOpinion tipo() {
		return this.tipo;
	}
	
	public boolean esOpinionDeExperto() {
		return esOpinionDeExperto;
	}

}
