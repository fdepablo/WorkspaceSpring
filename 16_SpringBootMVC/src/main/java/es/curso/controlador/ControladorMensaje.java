package es.curso.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorMensaje {

	@GetMapping("obtenerMensaje")
	public String obtenerMensaje(Model model) {
		System.out.println("obtenerMensaje -> Entrando");
		model.addAttribute("mensaje", "Hola mundo!");
		return "mensaje";
	}
}
