package es.codeurjc.emperorsleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Equipo;
import es.codeurjc.emperorsleague.repository.EquipoRepository;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository repository;

    public Optional<Equipo> findById(long id) {
        return repository.findById(id);
    }

    public Equipo getReferenceById(long id) {
        return repository.getReferenceById(id);
    }

    public List<Equipo> findAll() {
        return repository.findAll();
    }

    public void save(Equipo equipo) {
        repository.save(equipo);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
