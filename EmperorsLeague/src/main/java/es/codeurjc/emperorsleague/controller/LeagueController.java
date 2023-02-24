package es.codeurjc.emperorsleague.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.codeurjc.emperorsleague.model.Equipo;
import es.codeurjc.emperorsleague.model.Partido;

@Controller
public class LeagueController {
    ArrayList<Partido> partidos = new ArrayList<>();
	ArrayList<Equipo> equipos = new ArrayList<>();
	
	public  LeagueController() {
		Partido p1= new Partido("1-0","BCN-RMA");
		Partido p2= new Partido("2-0","MFC-ATH");
		partidos.add(p1);
		partidos.add(p2);
	}

	@GetMapping("/")
	public String greeting(Model model) {
		
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
	@GetMapping("/equipos")
	public String Clasificacion(Model model) {
		
		model.addAttribute("equipos",equipos);
		return "lista_equipos";
	}
	@GetMapping("/equipos/new")
	public String newEquipo(Model model) {

		return "new_equipo";
	}
	
	@PostMapping("/equipos/new")
	public String newEquipoProcess(Model model, Equipo equipo) {

		equipos.add(equipo);

		return "saved_equipo";
	}
	@GetMapping("/partidos/{numPartido}")
	public String showEquipos(Model model, @PathVariable int numEquipos) {

		Partido partido = partidos.get(numEquipos - 1);

		model.addAttribute("partido", partido);
		model.addAttribute("numPartido", numEquipos);

		return "show_partido";
	}
	@GetMapping("/partidos/{numPartido}/delete")
	public String deleteEquipo(Model model, @PathVariable int numEquipo) {

		partidos.remove(numEquipo - 1);

		return "deleted_partido";
	}
}
