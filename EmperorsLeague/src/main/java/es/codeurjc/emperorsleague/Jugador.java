package es.codeurjc.emperorsleague;

public class Jugador {
	private String Nombre;
	private String Apellidos;
	private int dorsal;
	
	public Jugador(String nombre, String apellidos, int dorsal) {
		Nombre = nombre;
		Apellidos = apellidos;
		this.dorsal = dorsal;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	
}
