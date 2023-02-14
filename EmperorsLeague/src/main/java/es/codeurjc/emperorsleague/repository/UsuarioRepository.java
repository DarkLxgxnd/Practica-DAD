package es.codeurjc.emperorsleague.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.codeurjc.emperorsleague.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Long, Usuario> {
	
}
