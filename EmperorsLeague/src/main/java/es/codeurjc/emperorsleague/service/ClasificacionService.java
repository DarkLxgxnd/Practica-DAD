package es.codeurjc.emperorsleague.service;

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

	public Clasificacion getReferenceById(long id) {
		return repository.getReferenceById(id);
	}

	public void save(Clasificacion clasificacion) {
		repository.save(clasificacion);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
}
