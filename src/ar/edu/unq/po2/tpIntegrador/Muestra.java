package ar.edu.unq.po2.tpIntegrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Muestra {

	private Usuario usuario;
	private LocalDate fecha;
	private Ubicacion ubicacion;
	private String foto;
	private Especie especie;
	private List<Opinion> opinionesCuantificables;
	private List<Opinion> opinionesHistoricas;
	private EstadoDeMuestra estado;

	public Muestra(Especie especie, String foto, Ubicacion ubicacion, Usuario usuario) throws Exception {
		this.especie = especie;
		this.foto = foto;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		this.fecha = LocalDate.now();
		this.estado = new MuestraVotada();
		this.opinionesCuantificables = new ArrayList<>();
		this.opinionesHistoricas = new ArrayList<>();
		this.inicializarOpiniones();
	}

	private void inicializarOpiniones() throws Exception {
		opinionesCuantificables = new ArrayList<>();
		opinionesHistoricas = new ArrayList<>();

		this.opinar(this.opinionInicial());
	}

	private Opinion opinionInicial() {
		return new Opinion(this.usuario, this.especie);
	}

	public boolean esVerificada() {
		return this.estado().esVerificadoConsiderando(opinionesCuantificables, this);
	}

	public void cambiarEstadoDeVerificacionCon(EstadoDeMuestra estado) {
		this.estado = estado;
	}

	public Opinable resultadoActual() {
		return ContadorDeOpiniones
				.usando(opinionesCuantificables.stream().map(Opinion::tipo).collect(Collectors.toList()))
				.opinionMasVotada();
	}

	public List<Opinion> opiniones() {
		return this.opinionesCuantificables;
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
	
	public boolean fueSubidaPor(Usuario unUsuario) {
		return this.usuario().esIgualA(unUsuario);
	}
	
	public EstadoDeMuestra estado() {
		return this.estado;
	}

	public void opinar(Opinion unaOpinion) throws Exception {
		validarQueNoHayaUnaOpinionHechaPor(unaOpinion.autor());
		opinarCon(unaOpinion);
	}

	private void validarQueNoHayaUnaOpinionHechaPor(Usuario unUsuario) throws Exception {
		// Chequeo que no exista la opini�n para contemplar el caso en el que un usuario
		// quiera votar dos veces sobre la misma muestra.
		if (this.opinionesCuantificables.stream().anyMatch(opinion -> opinion.fueRealizadaPor(unUsuario)))
			throw new Exception(
					"El usuario no puede votar sobre la muestra porque ya existe una opinion de su autoria sobre la misma");
	}

	private void opinarCon(Opinion unaOpinion) {
		if (!this.hayOpinionDeExperto() && unaOpinion.esDeExperto()) {

			// Si es la primera opini�n que hace un experto, reinicio las opiniones
			// cuantificables.

			this.opinionesCuantificables = new ArrayList<>();
		}
		if ((this.hayOpinionDeExperto() && unaOpinion.esDeExperto()) || !this.hayOpinionDeExperto()) {
			// Si no hay opinion de experto puedo incluir cualquier opinion. Si hay y la
			// opinion ingresada es de experto, se puede incluir.
			this.opinionesCuantificables.add(unaOpinion);
			this.opinionesHistoricas.add(unaOpinion);
		}
	}

	private boolean hayOpinionDeExperto() {
		return this.opinionesCuantificables.stream().anyMatch(Opinion::esDeExperto);
	}

	public boolean fueOpinadaPor(Usuario unUsuario) {
		return this.opinionesHistoricas.stream().anyMatch(opinion -> opinion.fueRealizadaPor(unUsuario));
	}
}
