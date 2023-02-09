package es.codeurjc.emperorsleague;

public class Partido {
  private String equipos;
  private String resultado;

public String getResultado() {
	return resultado;
}

public void setResultado(String resultado) {
	this.resultado = resultado;
}

public String getEquipos() {
	return equipos;
}

public void setEquipos(String equipos) {
	this.equipos = equipos;
}

public Partido(String resultado,String equipos) {
	this.resultado = resultado;
	this.equipos=equipos;
}
}
