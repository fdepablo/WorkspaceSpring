package com.controladores;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.modelo.entidades.Usuario;
import com.modelo.negocio.GestorUsuario;

@Controller
@Scope("request")
public class ControladorUsuario {

	@Autowired
	private GestorUsuario gu;
	
	@Autowired
	private Usuario usuario;
	
	//Solo entraremos por aqui cuando la url sea validar
	//y el verbo http sea POST
	@RequestMapping(value="validar",method=RequestMethod.POST)
	public String validar(
			@RequestParam("nombre") String nombre,
			@RequestParam("password") String password,
			Model model){
		
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		boolean estaValidado = gu.validarUsuario(usuario);
		if(estaValidado) {
			return "redirect:/mvc/peliculas/verListado";
		}else {
			String error = "Usuario con nombre: " + nombre +
					" y password " + password + " no existe";
			model.addAttribute("error",error);
			return "redirect:/index.jsp";
		}
	}
}







