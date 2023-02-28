package es.codeurjc.emperorsleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Clasificacion;
import es.codeurjc.emperorsleague.repository.ClasificacionRepository;

@Service
public class ClasificacionService {
    @Autowired
    private ClasificacionRepository repository;

    public Optional<Clasificacion> findById(long id) {
		return repository.findById(id);
	}

	public List<Clasificacion> findAll() {
		return repository.findAll();
	}

	public void save(Clasificacion clasificacion) {
		repository.save(clasificacion);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
