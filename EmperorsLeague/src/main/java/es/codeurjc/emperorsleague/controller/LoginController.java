package es.codeurjc.emperorsleague.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.codeurjc.emperorsleague.model.Usuario;
import es.codeurjc.emperorsleague.service.UsuarioService;

@Controller
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

	@Autowired
    private PasswordEncoder passwordEncoder;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}
	
	@GetMapping("/signup")
	public String newUsuario(Model model) {
		return "signup";
	}

	@PostMapping("/signup")
	public String newUsuarioProcess(Model model, @RequestParam String nombre, @RequestParam String contrasena, @RequestParam String correo) {
		usuarioService.save(new Usuario(nombre, correo, passwordEncoder.encode(contrasena), "USER"));

		return "signedup";
	}
}
