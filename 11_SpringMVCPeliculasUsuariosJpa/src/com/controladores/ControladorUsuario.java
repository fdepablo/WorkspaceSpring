package com.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.modelo.entidades.Usuario;
import com.modelo.negocio.GestorUsuario;
/**
 * 
 * Regla general: siempre que se haga un get, va un forward, (no redirect)
Regla general 2. Siempre que se haga un post, put o delete se hace un redirect. 

Forward: cuando mandamos sin salir del servidor a una pagina web, por ejemplo index.jsp
En este caso, los datos mandados van en los atributos de la request, y además pasamos por el viewResolver. 
La URL resultante en el cliente siempre es la primera que puso. Si pulsamos F5 recargaríamos el 
envío inicial, es decir, nos volvería a mandar el formulario. 

Redirect: Mandamos al cliente a una url nueva (respuesta 300 al cliente), en este caso mandamos los datos
como parámetros de la request y además NO pasamos por el view resolver. La URL resultante es la que hicimos
 con el redirect, y por tanto no debería de volver a mandarse los datos del formulario. 
 *
 */
@Controller
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







