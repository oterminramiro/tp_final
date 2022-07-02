package ar.edu.unq.po2.tpIntegrador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContadorDeOpiniones {

	private List<Opinable> opiniones;
	private List<Integer> indices;
	private Map<Integer, Opinable> ocurrencias;
	private Set<Opinable> set;
	
	public ContadorDeOpiniones() {
		opiniones = new ArrayList<>();
		ocurrencias = new HashMap<>();
		indices = new ArrayList<>();
		set = new HashSet<>();
	}
	
	public ContadorDeOpiniones(List<Opinable> opiniones) {
		this.opiniones = opiniones;
		ocurrencias = new HashMap<>();
		indices = new ArrayList<>();
		set = new HashSet<>(opiniones);
		this.procesarOpiniones();
	}

	public Opinable opinionMasVotada() {
		return ocurrencias.get(this.mayorCoincidenciaDeVotos());
	}

	private void procesarOpiniones() {
		for (Opinable opinable : set) {
			Integer frecuencia = Collections.frequency(opiniones, opinable);
			ocurrencias.put(frecuencia, opinable);
			indices.add(frecuencia);
		}
	}
	
	public int mayorCoincidenciaDeVotos() {
		return indices.stream().max(Integer::compare).get();
	}
}
