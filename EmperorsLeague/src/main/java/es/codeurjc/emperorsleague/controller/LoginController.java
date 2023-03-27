package es.codeurjc.emperorsleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.codeurjc.emperorsleague.model.Usuario;
import es.codeurjc.emperorsleague.service.UsuarioService;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}
	
	@GetMapping("/registro")
	public String newPartido(Model model) {
		return "registro";
	}

	@PostMapping("/registro")
	public String newPartido(Model model,  Usuario usuario) {
		
		usuarioService.save(usuario);

		return "registro";
	}
}
