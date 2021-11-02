package es.curso.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.modelo.negocio.GestorPelicula;

import es.curso.modelo.entidades.Pelicula;
import es.curso.modelo.entidades.Usuario;

@Controller
public class ControladorPelicula {

	@Autowired
	private GestorPelicula gp;
	
	@Autowired
	private Usuario usuario;
	
	@RequestMapping("peliculas/verListado")
	public ModelAndView listado() {
		if(usuario.getNombre() == null) {
			ModelAndView mav = new ModelAndView("redirect:/index.jsp");
			return mav;
			
		}
		List<Pelicula> listaPeliculas = gp.listar();
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		mav.addObject("listaPeliculas",listaPeliculas);
		mav.addObject("usuario",usuario);
		return mav;
	}
	
	@RequestMapping("peliculas/verFormulario")
	public ModelAndView formulario() {
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula",new Pelicula());
		return mav;
	}
	
	@RequestMapping(value="peliculas/insertar",
			method=RequestMethod.POST)
	public ModelAndView insertar(@ModelAttribute Pelicula pelicula,
			Model model) {
		gp.insertar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:/peliculas/verListado");
		return mav;
	}

	@RequestMapping("peliculas/seleccionar")
	public ModelAndView seleccionar(
			@RequestParam("id")Integer id) {
		Pelicula p = gp.buscar(id);
		ModelAndView mav = new ModelAndView("formularioPeliculas");
		mav.addObject("pelicula", p);
		return mav;
	}
	
	@RequestMapping(value="peliculas/modificar",
			method=RequestMethod.POST)
	public ModelAndView modificar(@ModelAttribute Pelicula pelicula) {
		gp.modificar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:/peliculas/verListado");
		return mav;
	}
	@RequestMapping(value="peliculas/borrar",
			method=RequestMethod.POST)
	public ModelAndView borrar(
			@ModelAttribute Pelicula pelicula) {
		gp.borrar(pelicula.getId());
		ModelAndView mav = new ModelAndView("redirect:/peliculas/verListado");
		return mav;
	}
}




