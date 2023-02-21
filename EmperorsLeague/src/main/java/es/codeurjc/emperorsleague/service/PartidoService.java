package es.codeurjc.emperorsleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Partido;
import es.codeurjc.emperorsleague.repository.PartidoRepository;

public class PartidoService {
	@Autowired
	private PartidoRepository repository;

	public Optional<Partido> findById(long id) {
		return repository.findById(id);
	}

	public List<Partido> findById(List<Long> ids){
		return repository.findAllById(ids);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Partido> findAll() {
		return repository.findAll();
	}

	public void save(Partido Partido) {
		repository.save(Partido);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
