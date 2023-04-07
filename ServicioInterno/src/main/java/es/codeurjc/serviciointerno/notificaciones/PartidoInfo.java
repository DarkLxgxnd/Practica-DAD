package es.codeurjc.serviciointerno.notificaciones;

import java.util.List;

public class PartidoInfo {
	private int golesLocal;
	private int golesVisitante;
	private List<String> equiposParticipantes;

	public PartidoInfo(int golesLocal, int golesVisitante, List<String> equiposParticipantes) {
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.equiposParticipantes = equiposParticipantes;
	}

	public int getGolesLocal() {
		return golesLocal;
	}

	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}

	public int getGolesVisitante() {
		return golesVisitante;
	}

	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}

	public List<String> getEquiposParticipantes() {
		return equiposParticipantes;
	}

	public void setEquiposParticipantes(List<String> equiposParticipantes) {
		this.equiposParticipantes = equiposParticipantes;
	}
}
