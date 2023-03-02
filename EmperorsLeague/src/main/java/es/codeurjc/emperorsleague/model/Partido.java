package es.codeurjc.emperorsleague.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int golesLocal;
	private int golesVisitante;

	@ManyToMany
	private List<Equipo> equiposParticipantes;
	
	public Partido() {
	}

	public Partido(int golesLocal, int golesVisitante) {
		this.golesLocal = golesLocal;
		this.golesVisitante = golesVisitante;
	}

	public long getId() {
		return id;
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

	public List<Equipo> getEquiposParticipantes() {
		return equiposParticipantes;
	}

	public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
		this.equiposParticipantes = equiposParticipantes;
	}

	public void setPuntos() {
		int i = 0;

		for (Equipo equipo: equiposParticipantes) {
			if (i == 0) {
				if (this.golesLocal > this.golesVisitante) {
					equipo.ganaPuntos();
				} else if (this.golesLocal == this.golesVisitante) {
					equipo.igualPuntos();
				}

				i++;
			} else {
				if (this.golesLocal < this.golesVisitante) {
					equipo.ganaPuntos();
				} else if (this.golesLocal == this.golesVisitante) {
					equipo.igualPuntos();
				}
			}
		}
	}
}
