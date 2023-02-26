package es.codeurjc.emperorsleague.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.codeurjc.emperorsleague.model.Equipo;
import es.codeurjc.emperorsleague.model.Jugador;
import es.codeurjc.emperorsleague.model.Partido;
import es.codeurjc.emperorsleague.service.EquipoService;
import es.codeurjc.emperorsleague.service.JugadorService;

@Controller
public class LeagueController {
    @Autowired
    private EquipoService equipoService;

	@Autowired
    private JugadorService jugadorService;
	
	ArrayList<Partido> partidos = new ArrayList<>();
	
	public  LeagueController() {
		Partido p1= new Partido("1-0","BCN-RMA");
		Partido p2= new Partido("2-0","MFC-ATH");
		partidos.add(p1);
		partidos.add(p2);
	}

	@GetMapping("/")
	public String inicio(Model model) {
		return "principal";
	}
	
	@GetMapping("/partidos")
	public String listaPartdios(Model model) {
	
		model.addAttribute("partidos",partidos);
		return "lista_partidos";
	}
	@PostMapping("/partidos/new")
	public String newPartido(Model model, Partido partido) {

		partidos.add(partido);

		return "saved_partido";
	}
	@GetMapping("/partidos/{numPartido}")
	public String showPartidos(Model model, @PathVariable int numPartido) {

		Partido partido = partidos.get(numPartido - 1);

		model.addAttribute("partido", partido);
		model.addAttribute("numPartido", numPartido);

		return "show_partido";
	}
	@GetMapping("/partidos/{numPartido}/delete")
	public String deletePartido(Model model, @PathVariable int numPartido) {

		partidos.remove(numPartido - 1);

		return "deleted_partido";
	}

	/* Equipos */
	
	@GetMapping("/equipos")
	public String showEquipos(Model model) {
		model.addAttribute("equipos", equipoService.findAll());

		return "lista_equipos";
	}

	@GetMapping("/equipos/new")
	public String newEquipo(Model model) {
		return "new_equipo";
	}
	
	@PostMapping("/equipos/new")
	public String newEquipoProcess(Model model, Equipo equipo) {
		equipoService.save(equipo);

		return "saved_equipo";
	}

	@GetMapping("/equipos/{id_equipo}")
	public String showEquipo(Model model, @PathVariable long id_equipo) {
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		model.addAttribute("equipo", equipo.get());

		return "show_equipo";
	}

	/* Jugadores */

	@GetMapping("/equipos/{id_equipo}/jugadores/new")
	public String newJugador(Model model, @PathVariable long id_equipo) {
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		model.addAttribute("equipo", equipo.get());
		
		return "new_jugador";
	}
	
	@PostMapping("/equipos/{id_equipo}/jugadores/new")
	public String newJugadorProcess(Model model, Jugador jugador, @PathVariable long id_equipo) {
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		jugador.setEquipo(equipoService.getReferenceById(id_equipo));
		jugadorService.save(jugador);

		model.addAttribute("equipo", equipo.get());

		return "saved_jugador";
	}

	@GetMapping("/equipos/{id_equipo}/jugadores/{id_jugador}")
	public String showJugador(Model model, @PathVariable long id_equipo, @PathVariable long id_jugador) {
		Optional<Jugador> jugador = jugadorService.findById(id_jugador);
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		model.addAttribute("jugador", jugador.get());
		model.addAttribute("equipo", equipo.get());

		return "show_jugador";
	}
}
