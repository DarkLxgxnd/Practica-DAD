package es.codeurjc.emperorsleague.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.emperorsleague.events.ComunicacionSender;
import es.codeurjc.emperorsleague.events.NotificacionesReceiver;
import es.codeurjc.emperorsleague.events.NotificacionesSender;
import es.codeurjc.emperorsleague.model.Clasificacion;
import es.codeurjc.emperorsleague.model.Equipo;
import es.codeurjc.emperorsleague.model.Jugador;
import es.codeurjc.emperorsleague.model.Partido;
import es.codeurjc.emperorsleague.service.ClasificacionService;
import es.codeurjc.emperorsleague.service.EquipoService;
import es.codeurjc.emperorsleague.service.JugadorService;
import es.codeurjc.emperorsleague.service.PartidoService;

@Controller
public class LeagueController {
    @Autowired
	private ClasificacionService clasificacionService;
	
	@Autowired
    private PartidoService partidoService;
	
	@Autowired
    private EquipoService equipoService;

	@Autowired
    private JugadorService jugadorService;

	@Autowired
	private ComunicacionSender comunicacionSender;

	@Autowired
	private NotificacionesSender notificacionesSender;

	@Autowired
	private NotificacionesReceiver notificacionesReceiver;

	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();

		if (principal != null) {
			model.addAttribute("logged", true);
			model.addAttribute("userName", principal.getName());
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
			model.addAttribute("manager", request.isUserInRole("MANAGER"));
			model.addAttribute("user", request.isUserInRole("USER"));
		} else {
			model.addAttribute("logged", false);
		}
	}

	/* Página Principal */

	@GetMapping("/")
	public String inicio(Model model) {
		return "principal";
	}

	/* Clasificacion */

	@GetMapping("/clasificacion")
	public String showClasificacion(Model model) {
		Clasificacion clasificacion = clasificacionService.getReferenceById(1);

		clasificacion.setEquipos(equipoService.findAll());
        clasificacion.ordenarEquipos();
		model.addAttribute("clasificacion", clasificacion);

		return "show_clasificacion";
	}

	/* Partidos */
	
	@GetMapping("/partidos")
	public String showPartidos(Model model) {
		model.addAttribute("partidos", partidoService.findAll());

		return "lista_partidos";
	}

	@GetMapping("/partidos/new")
	public String newPartido(Model model) {
		model.addAttribute("equipos", equipoService.findAll());

		return "new_partido";
	}

	@PostMapping("/partidos/new")
	public String newPartido(Model model, Partido partido) {
		partido.setPuntos();
		createNotificaciones(partido);
		partidoService.save(partido);

		return "saved_partido";
	}

	@GetMapping("/partidos/{id_partido}")
	public String showPartido(Model model, @PathVariable long id_partido) {
		Optional<Partido> partido = partidoService.findById(id_partido);

		model.addAttribute("partido", partido.get());

		return "show_partido";
	}

	@GetMapping("/partidos/{id_partido}/delete")
	public String deletePartido(Model model, @PathVariable long id_partido) {
		partidoService.delete(id_partido);

		return "deleted_partido";
	}

	@GetMapping("/partidos/{id_partido}/edit")
	public String editPartido(Model model, @PathVariable long id_partido) {
		Optional<Partido> partido = partidoService.findById(id_partido);

		model.addAttribute("equipos", equipoService.findAll());
		model.addAttribute("partido", partido.get());

		return "edit_partido";
	}

	@PostMapping("/partidos/{id_partido}/edit")
	public String editPartidoProcess(Model model, Partido partido, @PathVariable long id_partido) {
		partidoService.save(partido);

		return "edited_partido";
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

	@GetMapping("/equipos/{id_equipo}/delete")
	public String deleteEquipo(Model model, @PathVariable long id_equipo) {
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		equipoService.delete(id_equipo);
		model.addAttribute("equipo", equipo.get());

		return "deleted_equipo";
	}

	@GetMapping("/equipos/{id_equipo}/edit")
	public String editEquipo(Model model, @PathVariable long id_equipo) {
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		model.addAttribute("equipo", equipo.get());

		return "edit_equipo";
	}

	@PostMapping("/equipos/{id_equipo}/edit")
	public String editEquipoProcess(Model model, Equipo equipo, @PathVariable long id_equipo) {
		equipoService.save(equipo);

		return "edited_equipo";
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

	@GetMapping("/equipos/{id_equipo}/jugadores/{id_jugador}/delete")
	public String deleteJugador(Model model, @PathVariable long id_equipo, @PathVariable long id_jugador) {
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		jugadorService.delete(id_jugador);
		model.addAttribute("equipo", equipo.get());

		return "deleted_jugador";
	}

	@GetMapping("/equipos/{id_equipo}/jugadores/{id_jugador}/edit")
	public String editJugador(Model model, @PathVariable long id_equipo, @PathVariable long id_jugador) {
		Optional<Jugador> jugador = jugadorService.findById(id_jugador);
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		model.addAttribute("jugador", jugador.get());
		model.addAttribute("equipo", equipo.get());


		return "edit_jugador";
	}

	@PostMapping("/equipos/{id_equipo}/jugadores/{id_jugador}/edit")
	public String editJugadorProcess(Model model, Jugador jugador, @PathVariable long id_equipo, @PathVariable long id_jugador) {
		Optional<Equipo> equipo = equipoService.findById(id_equipo);

		jugadorService.save(jugador);
		model.addAttribute("equipo", equipo.get());

		return "edited_jugador";
	}

	/* Servicio Interno */

	@GetMapping("/comunicaciones/new")
	public String newComunicacion(Model model) {
		return "new_comunicacion";
	}

	@PostMapping("/comunicaciones/new")
	public String newComunicacionProcess(Model model, @RequestParam String titulo, @RequestParam String contenido) {
		comunicacionSender.sendComunicacion(titulo, contenido);
		
		return "sent_comunicacion";
	}

	@GetMapping("/notificaciones")
	public String showNotificaciones(Model model) {
		model.addAttribute("notificaciones", notificacionesReceiver.getNotificaciones());
		
		return "show_notificaciones";
	}

	public void createNotificaciones(Partido partido) {
		List<Equipo> equipos = partido.getEquiposParticipantes();
		Equipo equipoLocal = equipos.get(0);
		Equipo equipoVisitante = equipos.get(1);

		if (partido.getGolesLocal() > partido.getGolesVisitante()) {
			notificacionesSender.sendNotificacion(equipoLocal.getNombre(), "¡Nueva victoria de " + equipoLocal.getNombre() + "!", "" + equipoLocal.getNombre() + " ha ganado " + partido.getGolesLocal() + "-" + partido.getGolesVisitante() + " ante " + equipoVisitante.getNombre());
			notificacionesSender.sendNotificacion(equipoVisitante.getNombre(), "¡Nueva derrota de " + equipoVisitante.getNombre() + "!", "" + equipoVisitante.getNombre() + " ha perdido " + partido.getGolesVisitante() + "-" + partido.getGolesLocal() + " ante " + equipoLocal.getNombre());
		} else if (partido.getGolesLocal() == partido.getGolesVisitante()) {
			notificacionesSender.sendNotificacion(equipoLocal.getNombre(), "¡Nuevo empate de " + equipoLocal.getNombre() + "!", "" + equipoLocal.getNombre() + " ha empatado " + partido.getGolesLocal() + "-" + partido.getGolesVisitante() + " ante " + equipoVisitante.getNombre());
			notificacionesSender.sendNotificacion(equipoVisitante.getNombre(), "¡Nuevo empate de " + equipoVisitante.getNombre() + "!", "" + equipoVisitante.getNombre() + " ha empatado " + partido.getGolesVisitante() + "-" + partido.getGolesLocal() + " ante " + equipoLocal.getNombre());
		} else {
			notificacionesSender.sendNotificacion(equipoLocal.getNombre(), "¡Nueva derrota de " + equipoLocal.getNombre() + "!", "" + equipoLocal.getNombre() + " ha perdido " + partido.getGolesLocal() + "-" + partido.getGolesVisitante() + " ante " + equipoVisitante.getNombre());
			notificacionesSender.sendNotificacion(equipoVisitante.getNombre(), "¡Nueva victoria de " + equipoVisitante.getNombre() + "!", "" + equipoVisitante.getNombre() + " ha ganado " + partido.getGolesVisitante() + "-" + partido.getGolesLocal() + " ante " + equipoLocal.getNombre());
		}
	}
}
