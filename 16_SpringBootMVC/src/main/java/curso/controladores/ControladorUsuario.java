package curso.controladores;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidades.Usuario;
import curso.modelo.negocio.GestorUsuario;


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
	public ModelAndView validar(
			@RequestParam("nombre") String nombre,
			@RequestParam("password") String password) {
		
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		boolean estaValidado = gu.validar(usuario);
		if(estaValidado) {
			ModelAndView mav =
					new ModelAndView("redirect:/peliculas/verListado");
			return mav;
		}else {
			ModelAndView mav = 
					new ModelAndView("redirect:/index.jsp");
			String error = "Usuario con nombre: " + nombre +
					" y password " + password + " no existe";
			mav.addObject("error",error);
			return mav;
		}
	}
}







