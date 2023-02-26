package es.codeurjc.emperorsleague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.codeurjc.emperorsleague.model.Jugador;
import es.codeurjc.emperorsleague.repository.JugadorRepository;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository repository;

    public Optional<Jugador> findById(long id) {
        return repository.findById(id);
    }

    public List<Jugador> findAll() {
        return repository.findAll();
    }

    public void save(Jugador jugador) {
        repository.save(jugador);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
