package ar.edu.unq.po2.tpIntegrador;

public enum Especie{
	INFESTANS(TipoOpinion.VINCHUCA_INFESTANS), 
	SORDIDA(TipoOpinion.VINCHUCA_SORDIDA), 
	GUASAYANA(TipoOpinion.VINCHUCA_GUASAYANA);
	
	private TipoOpinion opinion;
	
	private Especie(TipoOpinion opinionAsociada) {
		this.opinion = opinionAsociada;
	}
	
	public TipoOpinion convertidaAOpinion() {
		return this.opinion;
	}
}
