package es.codeurjc.emperorsleague;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PartidoController {
	ArrayList<Partido> partidos = new ArrayList<>();
	
	public  PartidoController() {
		Partido p1= new Partido("1-0","BCN-RMA");
		Partido p2= new Partido("2-0","MFC-ATH");
		partidos.add(p1);
		partidos.add(p2);
	}

	@GetMapping("/")
	public String greeting(Model model) {
	
		model.addAttribute("partidos",partidos);
		return "lista_partidos";
	}
	@PostMapping("/partidos/new")
	public String newPartido(Model model, Partido partido) {

		partidos.add(partido);

		return "saved_partido";
	}
	@GetMapping("/partido/{numPartido}")
	public String showPartidos(Model model, @PathVariable int numPartido) {

		Partido partido = partidos.get(numPartido - 1);

		model.addAttribute("part", partido);
		model.addAttribute("numPartido", numPartido);

		return "show_partido";
	}
	@GetMapping("/partido/{numPartido}/delete")
	public String deletePartido(Model model, @PathVariable int numPartido) {

		partidos.remove(numPartido - 1);

		return "deleted_partido";
	}
}
