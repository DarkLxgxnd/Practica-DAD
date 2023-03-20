package es.codeurjc.emperorsleague.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String correo;

	private String encodedContrasena;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	public Usuario() {
	}
	
	public Usuario(String nombre, String correo) {
		this.nombre = nombre;
		this.correo = correo;
	}
	
	public Usuario(String name, String encodedPassword, String... roles) {
		this.nombre= name;
		this.encodedContrasena = encodedPassword;
		this.roles = List.of(roles);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEncodedContrasena() {
		return encodedContrasena;
	}

	public void setEncodedContrasena(String encodedContrasena) {
		this.encodedContrasena = encodedContrasena;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
