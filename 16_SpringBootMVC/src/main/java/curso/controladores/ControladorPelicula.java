package curso.controladores;

import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.modelo.entidades.Pelicula;
import curso.modelo.negocio.GestorPelicula;


@Controller
@Scope("request")
public class ControladorPelicula {

	Logger logger = LoggerFactory.getLogger(ControladorPelicula.class);
	
	@Autowired
	private GestorPelicula gp;
	
	@RequestMapping("peliculas/verListado")
	public ModelAndView listado() {
		List<Pelicula> listaPeliculas = gp.listar();
		ModelAndView mav = new ModelAndView("listadoPeliculas");
		mav.addObject("listaPeliculas",listaPeliculas);
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
	public ModelAndView insertar(
			@Valid @ModelAttribute Pelicula pelicula,
			BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("formularioPeliculas");
			//String mensajeErrores = "";
			for(FieldError fe : br.getFieldErrors()) {
				//String campo = fe.getField();
				//String mensaje = fe.getDefaultMessage();
				//mensajeErrores += campo + " - " + mensaje;
				
				String error = "error_" + fe.getField();
				mav.addObject(error, fe.getDefaultMessage());
			}
			
			//mav.addObject("errores", mensajeErrores);
			return mav;
		}
		gp.insertar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:verListado");
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
	public ModelAndView modificar(
			@Valid @ModelAttribute Pelicula pelicula, BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("formularioPeliculas");
			for(FieldError fe : br.getFieldErrors()) {
				String error = "error_" + fe.getField();
				mav.addObject(error, fe.getDefaultMessage());
			}
			return mav;
		}
		gp.modificar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:verListado");
		return mav;
	}
	@RequestMapping(value="peliculas/borrar",
			method=RequestMethod.POST)
	public ModelAndView borrar(
			@ModelAttribute Pelicula pelicula) {
		gp.borrar(pelicula);
		ModelAndView mav = new ModelAndView("redirect:verListado");
		return mav;
	}
}




