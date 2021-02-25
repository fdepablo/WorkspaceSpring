package controladores;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import modelo.entidades.Usuario;
import modelo.negocio.GestorUsuarios;

@Controller
@Scope("request")
@RequestMapping("usuarios")
public class ControladorUsuarios {
	
	@Autowired
	private GestorUsuarios gUsuarios;

	@RequestMapping("index")
	public ModelAndView login(HttpSession session) {
		String mensajeError = "Error, el nombre de usuario o la contraseña no son correctos.";
		session.setAttribute("error", mensajeError);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(path="ingresarListadoVideojuegos", method=RequestMethod.GET)
	public ModelAndView ingresarUsuario(@Valid @RequestParam("nombre") String nombre,
										@Valid @RequestParam("password") String password,
										HttpSession session)
	{
		ModelAndView mav;
		if(!gUsuarios.buscar(nombre, password)) {
			mav = new ModelAndView("redirect:/mvc/usuarios/index");
		} else {
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setPassword(password);
			session.setAttribute("usuario", usuario);
			mav = new ModelAndView("redirect:/mvc/videojuegos/verListado");
		}
		return mav;
	}
	
	@RequestMapping(path="altaUsuario", method=RequestMethod.GET) 
	public ModelAndView altaUsuario() {
		ModelAndView mav = new ModelAndView("creacionUsuario");
		return mav;
	}
	
	@RequestMapping(path="insertarUsuario", method=RequestMethod.POST) 
	public ModelAndView insertarUsuario(@Valid @RequestParam("nombre") String nombre,
										@Valid @RequestParam("password") String password) 
	{
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		gUsuarios.insertar(usuario);
		return new ModelAndView("redirect:/");
	}
	
}
