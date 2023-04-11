package es.codeurjc.serviciointerno.notificaciones;

import java.io.Serializable;

public class PartidoInfo implements Serializable {
	private int golesLocal;
	private int golesVisitante;
	private String equipoLocal;
	private String equipoVisitante;

	public PartidoInfo() {
	}

	public PartidoInfo(int golesLocal, int golesVisitante, String equipoLocal, String equipoVisitante) {
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
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

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	@Override
	public String toString() {
		return "PartidoInfo [golesLocal=" + golesLocal + ", golesVisitante=" + golesVisitante + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + "]";
	}
}
