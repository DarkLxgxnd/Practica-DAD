package es.codeurjc.emperorsleague.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Partido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String equipos;
	private String resultado;
	
	public Partido() {
	}
	
	public Partido(String resultado, String equipos) {
		this.resultado = resultado;
		this.equipos = equipos;
	}

	public String getEquipos() {
		return equipos;
	}

	public void setEquipos(String equipos) {
		this.equipos = equipos;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
