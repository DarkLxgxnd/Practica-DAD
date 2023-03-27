package es.codeurjc.emperorsleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Usuario;
import es.codeurjc.emperorsleague.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
	private UsuarioRepository repository;
    
	public Optional<Usuario> findById(long id) {
		return repository.findById(id);
	}

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public void save(Usuario usuario) {
		repository.save(usuario);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}

